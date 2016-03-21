@wip
Feature: [CLW001] Navigate from resource to resource and verify the different types of links

  Scenario Outline: For the sample doc verify the jump links, internal and external links,links to other plc docs
    Given the "<PLC document>" of type "<PLC document TYPE>" exists on Novus platform
    And for "<PLC document>" I get all the different types of Links from Fatwire XML
    And for "<PLC document>" I get all the different types of Links from NOVUS XML
    #And compare the number of links manually from the excel sheet created in C:\temp
  Examples:
    | PLC document TYPE     | PLC document |
    | Practice Note         | 8-383-5739   |
    | External resource     | 7-516-0749   |
    | Country Q&A documents | 0-521-3360   |
   #R3| Binary Content      |3-525-2190   |
   #R3| Legislation Primary Source page      | 4-505-6037   |
   #R3| Case Primary Source page    | D-000-0937   |
# Not sure about Whats market, Whats market deals. May have to test manually

    # By Radhika
    # The above testcase was started to merge all the linking testcases to a single testcase.It may be deleted.






