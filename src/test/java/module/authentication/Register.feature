Feature: Register Aplikasi GTPL Bank

  Scenario: Register dengan email valid
    
   Given User sedang berada di halaman register
   When User memasukan email "yanwarsolah@gmail.com"
   When User menekan tombol submit
   And User akan melihat kredensial yang diberikan
   Then close driver
   
  Scenario: Register dengan email invalid
    
   Given User sedang berada di halaman register
   When User memasukan email "yanwarsolah.com"
   When User menekan tombol submit
   And User akan melihat pesan validasi "Email ID is not valid"
   Then close driver