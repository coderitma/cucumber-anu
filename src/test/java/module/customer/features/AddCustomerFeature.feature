Feature: Add Customer from customer module

  Scenario: Input data customer
    Given ada di halaman dashboard
    When tekan menu customer
    When ada di halaman customer
    When ceklis done
    When isi first name "Yanwar"
    When isi last name "Solahudin"
    When isi email "yanwarsolah@mail.com"
    When isi address "Jakarta"
    When isi mobile phone "0897687655"
    When klik submit
    Then dapat kode customer