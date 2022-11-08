Feature:

  Jako uzytkownik chce miec mozliwosc zalogowania sie do aplikacji

  Scenario: Poprawne logowanie do aplikacji aby moc korzystac z zaawansowanych funkcji systemu
    Given Uzytkownik otwiera przegladarke
    And Uzytkownik wpisuje adres https://the-internet.herokuapp.com/login
    When Uzytkownik wpisuje poprawny username
    And Uzytkownik wpisuje poprawne haslo
    And Uzytkownik kilka przycisk Login
    Then Uzytkownik zostaje zalogowany

  Scenario: Niepoprawne logowanie do aplikacji aby moc korzystac z zaawansowanych funkcji systemu
    Given
    When
    Then