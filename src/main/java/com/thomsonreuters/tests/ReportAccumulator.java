package main.java.com.thomsonreuters.tests;

import org.apache.commons.io.FileUtils;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public final class ReportAccumulator {

    protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ReportAccumulator.class);
    private static String reportJS = "report.js";
    private static String pngImageExtension = "png";
    private static File plPlusUKFolder = null;
    private static File plplusukReportsFolder = null;
    private File mergedReport = null;

    public static void main(String[] args) throws Throwable {
        setBaseFolder();
        plplusukReportsFolder = new File(plPlusUKFolder + "\\target\\cucumber-htmlreport\\");
        ReportAccumulator reportAccumulator = new ReportAccumulator();
        reportAccumulator.startReporting();
    }


    public void startReporting() throws Throwable {
        if (!plplusukReportsFolder.exists()) {
            plplusukReportsFolder.mkdirs();
        }

        LOG.info("Calling merge reports");

        List<String> modules = getModuleNames();
        Iterator<String> modulesList = modules.iterator();

        while (modulesList.hasNext()) {
            try {
                String module =  modulesList.next();
                String moduleName = plPlusUKFolder + "\\" +module;
                File moduleReportsFolder = new File(moduleName + "\\target\\cucumber-htmlreport\\");
                if (!moduleReportsFolder.isDirectory()) {
                    return;
                }

                for (File file : moduleReportsFolder.listFiles()) {
                    if (file.isDirectory()) {
                        if (new File(file, "index.html").exists()) {
                            LOG.info("Module -> "+module+" ::report location ::" + moduleReportsFolder + "\\" + file.getName());
                            mergeReports(new File(moduleReportsFolder + "\\" + file.getName()));
                        }
                    }
                }
            } catch (Exception e) {
                LOG.warn(e.getMessage());
            }
        }
    }

    /**
     * Merge all reports together into master report in given reportDirectory
     *
     * @param reportDirectory
     * @throws Exception
     */
    private void mergeReports(File reportDirectory) throws Throwable {
        LOG.info("1");
        boolean isEmpty = false;
        Collection<File> existingReports = FileUtils.listFiles(reportDirectory, new String[]{"js"}, true);

        if (plplusukReportsFolder.listFiles().length == 0) {
            existingReports = Arrays.asList(reportDirectory.listFiles());
            isEmpty = true;
        }

        for (File report : existingReports) {
            //only address report files
            if (isEmpty || report.getName().equals(reportJS)) {

                //rename all the image files (to give unique names) in report directory and update report
                renameEmbededImages(report);

                //if we are on the first pass, copy the directory of the file to use as basis for merge
                if (isEmpty) {
                    copyFileUsingStream(report);
                    if(report.getName().equals(reportJS)){
                        mergedReport = report;
                    }
                    //otherwise merge this report into existing master report
                } else {
                    mergeFiles(mergedReport, report);
                }
            }
        }
        LOG.info("10");

    }

    /**
     * merge source file into target
     *
     * @param target
     * @param source
     */
    private void mergeFiles(File target, File source) throws Throwable {
        //copy embeded images
        Collection<File> embeddedImages = FileUtils.listFiles(source.getParentFile(), new String[]{pngImageExtension}, true);
        try {
            for (File image : embeddedImages) {
                FileUtils.copyFileToDirectory(image, target.getParentFile());
            }
        } catch (Exception e) {
            LOG.warn("Issue in copying images. :" + e.getMessage());
        }
        //merge report files
        String targetReport = FileUtils.readFileToString(target);
        String sourceReport = FileUtils.readFileToString(source);
        FileUtils.writeStringToFile(target, targetReport + sourceReport);
        copyFileUsingStream(target);
    }

    /**
     * Give unique names to embedded images to ensure they aren't lost during merge
     * Update report file to reflect new image names
     *
     * @param reportFile
     */
    private void renameEmbededImages(File reportFile) throws Throwable {
        try {
            File reportDirectory = reportFile.getParentFile();
            Collection<File> embeddedImages = FileUtils.listFiles(reportDirectory, new String[]{pngImageExtension}, true);

            String fileAsString = FileUtils.readFileToString(reportFile);

            for (File image : embeddedImages) {
                String curImageName = image.getName();
                String uniqueImageName = UUID.randomUUID().toString() + "." + pngImageExtension;

                image.setWritable(true);
                //image.renameTo(new File(reportDirectory, uniqueImageName));
                if(image.renameTo(new File(reportDirectory, uniqueImageName))){
                    LOG.info("Image File renamed to avoid the file overriding issues.");
                    fileAsString = fileAsString.replace(curImageName, uniqueImageName);
                }else{
                    LOG.warn("Sorry! the image file can't be renamed" + image.getName());
                }
                Thread.sleep(2000);
            }
            FileUtils.writeStringToFile(reportFile, fileAsString);
        } catch (Exception e) {
            LOG.warn("Issue in renameEnbeddedImages() :" + e.getMessage());
        }
    }

    private static List<String> getModuleNames() {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = null;
        try {
            model = reader.read(new FileReader(plPlusUKFolder+"\\pom.xml"));
        } catch (IOException e) {
        } catch (XmlPullParserException e) {
        }
        //LOG.info("Modules :" + model.getModules());
        return model.getModules();
    }

    private static void setBaseFolder() {
        String dir = System.getProperty("user.dir");
        dir = dir.substring(0, dir.indexOf("PLPlusUK")) + "PLPlusUK";
        plPlusUKFolder = new File(dir);
    }

    private void copyFileUsingStream(File source) throws IOException {
        File dest = new File(plplusukReportsFolder + "\\" + source.getName());
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            is.close();
            os.close();
        }
    }
}