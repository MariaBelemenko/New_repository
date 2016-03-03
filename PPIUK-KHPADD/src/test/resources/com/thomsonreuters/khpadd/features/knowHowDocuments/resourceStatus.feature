Feature: [730589] Verify metadata on the document
  I want: to see metadata information in the right hand column
  So that: I can view resource type, resource status (maintained status / date) and author

  Scenario Outline: Verify the resource status is displayed on right hand side column
    Given PL+ user is logged in
    When user navigates directly to document with guid "<guid>"
    Then resource status "<status>" is displayed on the document right hand panel
  Examples:
    | guid                              | status                       |
    | Ibf98459ce84d11e398db8b09b4f043e0 | Published on 02-Apr-2014     |
    | I3351a82be8da11e398db8b09b4f043e0 | Maintained                   |
    | I33f12f6ce8cd11e398db8b09b4f043e0 | Law stated as at 30-Sep-2010 |
