Feature: palindrom word
  Scenario: test valid palindrom
    Given memasukan kata berupa "apa"
    When cek palindrom
    Then hasil harus "true"
  Scenario: test invalid palindrom
    Given memasukan kata berupa "kasur"
    When cek palindrom
    Then hasil harus "false"
