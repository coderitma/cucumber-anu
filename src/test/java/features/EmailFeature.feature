Feature: Tentukan apakah email memiliki format yang valid atau tidak.

  Scenario: Valid email
    Given saya memasukkan email "budi@mail.com"
    When saya test formatnya
    Then hasilnya harus "true"
  
  Scenario: Invalid Email
    Given saya memasukkan email "budi"
    When saya test formatnya
    Then hasilnya harus "false"