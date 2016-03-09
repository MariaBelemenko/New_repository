package com.thomsonreuters.pageobjects.rest;

import com.thomsonreuters.pageobjects.rest.service.impl.RestServiceFFHImpl;
import com.thomsonreuters.pageobjects.utils.OnepassLoginUtils;

public class FolderBaseUtils {

    private OnepassLoginUtils onepassLoginUtils = new OnepassLoginUtils(); // To avoid NPE

    private RestServiceFFHImpl restService = new RestServiceFFHImpl();

    public void createFolder(String newFolderName, String parentFolderName) {
        String rootFolderID = getRootFolderID();
        restService.postCreateFolder(newFolderName, rootFolderID);
    }

    public void doSuperDelete() {
        restService.setOnepassLoginUtils(onepassLoginUtils);
        restService.deleteDoSuperDelete();
    }
    
    @Deprecated
    public void wlnDoSuperDelete() {
        restService.wlnDeleteDoSuperDelete();
    }

    private String getRootFolderID() {
        return restService.getRootAncestors()[0].getCategoryId();
    }

    public void setOnepassLoginUtils(OnepassLoginUtils onepassLoginUtils) {
        this.onepassLoginUtils = onepassLoginUtils;
    }
}
