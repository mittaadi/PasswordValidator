Feature: Customer creation

  @PasswordValidator
  Scenario Outline: : Validate update password Feature
    Given User inputs "<OldPassword>" password and "<NewPassword>" password
    Then Verify old password should match with system
    Then Verify the new password is a valid password
    Then Verify new password is not similar to old password <80% match

    Examples:
      |OldPassword|NewPassword|