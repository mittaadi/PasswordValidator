Feature: Update new password

  Scenario Outline: Validate update password Feature
    Given User inputs "<OldPassword>" password
    Then Verify old password should match with system
    Then Verify the new password "<NewPassword>" is a valid password
    Then Verify new password is similar to old password for less than 80% match

    Examples:
      | OldPassword          | NewPassword                 |
      | ExistingPassword@123 | Newpassword!2019@07         |
#      | ExistingPassword@123 | NewPassword                 |
#      | ExistingPassword@123 | NewPasswordNoNumber!        |
#      | ExistingPassword@123 | NewPasswordNoSpecialChar12  |
#      | ExistingPassword@123 | 1234567890!@#12345          |
#      | ExistingPassword@123 | NewPassword^CheckSpecial    |
#      | ExistingPassword@123 | newpasswordnouppercase12#   |
#      | ExistingPassword@123 | NewPasswordDuuuuupCheck123& |
#      | ExistingPassword@123 | NewPassword!@#$&*90         |
#      | ExistingPassword@123 | NewPassword12345678901!     |
#      | ExistingPassword@123 | ExistingPassword@123        |