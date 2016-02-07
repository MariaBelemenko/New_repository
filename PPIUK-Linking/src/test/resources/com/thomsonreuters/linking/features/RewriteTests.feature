@manual
Feature: Rewrite rule tests for filter content retriever

  #=============================================================================================
  # The below test cases are not to be run as part of regression testacses
  #=============================================================================================
 # Background: Place the plc ref is saved in a txt file
 #  Step1 : In winscp logon the server 10.222.40.100 (jbown102/darw1nd102) to /apps1/instance_<your environment>/output_files /content_analysis/retro
 #  Step2 : In winscp logon on to 10.222.40.100 with ftp_novus/suvon_ptf to /home/ftp_novus/CA-RETROSPECTIVE_<your environment>
 #  Given the txt file is placed in Step1

  #Scenario : CP -59 Replace plcrefs in content with appropriate "our team" URLs as per Apache rewrites
  #  When the text file moves to Done folder
  #  And the user sees the zip file in Step2 after 10 min
  #  Then the resultant file should contain /about/our-team url
    #3-382-1283 � For the link text- professional support team(8-381-7467 ) the url should change to /about/our-team/uk-arbitration - DO NOT WORK on PL+

#  Scenario : CP-62 Replace ASPID hrefs in content with appropriate Plcref for "Article" links
 #   When the text file moves to Done folder
  #  And the user sees the zip file in Step2 after 10 min
  #  Then the resultant file should replace the A10039 to 1-100-9297
  #  #8-102-6062- in the xml www.practicallaw.com/A10039 should be replaced by plcref === works on PL+

 # Scenario : CP-63 Replace ASPID hrefs in content with appropriate Plcref for "Web" links
 #   When the text file moves to Done folder
 #   And the user sees the zip file in Step2 after 10 min
  #  Then the resultant file should replace the W1363 to 4-106-4391
 #   #0-102-5660- in the xml the href of W1363 should be replaced to 4-106-4391 === works on PL+

  #Scenario : CP-75 Replace POID binary content hrefs with appropriate plcref in legacy content
  #  When the text file moves to Done folder
  #  And the user sees the zip file in Step2 after 10 min
  #  Then the resultant file should replace href="/jsp/binaryContent.jsp?item=:46576244" to href="4-383-2375"
  #  #3-501-0870 - in the xml replace href="/jsp/binaryContent.jsp?item=:46576244" to href="4-383-2375" === works on PL+

  #Scenario : CP-79 Replace plcrefs in content with appropriate "Resource collection" URLs as per Apache rewrites
  #  When the text file moves to Done folder
   # And the user sees the zip file in Step2 after 10 min
   # Then the resultant file should replace /1-107-4867 with /resources/documents/uk-corporate
    #7-516-6850- replace /1-107-4867  to /resources/documents/uk-corporate - ASK doc older than two years. so not on Pl+. No other example found

    #Scenario : CP-84 Replace legacy POID links which end with ?item=:<a-reference-number> with appropriate plcref
  #  When the text file moves to Done folder
   # And the user sees the zip file in Step2 after 10 min
   # Then the resultant file should replace /1-107-4867 with /resources/documents/uk-corporate
    #5-107-4865- replace /1-107-3967  to /resources/documents/uk-corporate (link text:Undue influence and the Etridge principles)
    # Currently it does naviagte to the doc but the url changes to https://a.uk.practicallaw.demo.thomsonreuters.com/co_anchor_N/A which may be incorrect.
    # Emailed Paul aprkins and Jim stiner - 13 November 2015 13:52

    #Scenario : CP-94 Old ASPID links that include an anchor are not processed
  #  When the text file moves to Done folder
   # And the user sees the zip file in Step2 after 10 min
   # Then the resultant file should replace /A46158#a435737 with /8-103-2553#a435737"
    #2-107-3532- replace /A46158#a435737 with /8-103-2553#a435737" link text: Tax: pre-budget report 2004: Finance leasing ( www.practicallaw.com/A46158)).

    #
    #The above rewrite urls may be automated for ease but they need not be part of regression suite as link resolver may not be changed fo rewrites quite often,
    #and there is no PPI APP work for this
    #