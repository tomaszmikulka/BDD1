Feature: Logowanie do systemu

  Jako uzytkownik chce miec mozliwosc zalogowania sie do aplikacji

  @web
  Scenario: Poprawne logowanie do aplikacji aby moc korzystac z zaawansowanych funkcji systemu
    Given Uzytkownik otwiera przegladarke
    Given Uzytkownik wpisuje adres https://the-internet.herokuapp.com/login
    When Uzytkownik wpisuje poprawny username
    And Uzytkownik wpisuje poprawne haslo
    And Uzytkownik kilka przycisk Login
    Then Uzytkownik zostaje zalogowany

@later
  Scenario: Niepoprawne logowanie do aplikacji aby moc korzystac z zaawansowanych funkcji systemu
    Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    #When Uzytkownik wpisuje poprawny username
    When Uzytkownik wpisuje "tomsmith" username
    #And Uzytkownik wpisuje poprawne haslo
    And Uzytkownik wpisuje "SuperSecretPassword!" w pole password
    And Uzytkownik kilka przycisk Login
    Then Uzytkownik zostaje zalogowany

@later
  Scenario: Niepoprawne logowanie do aplikacji (Druga wersja)
    Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    When Uzytkownik wpisuje "tomsmith" username
    And Uzytkownik wpisuje "niePasujaceHaslo" w pole password
    And Uzytkownik kilka przycisk Login
    Then Uzytkownik nie zostaje zalogowany

  @now
  Scenario Outline: Niepoprawne logowanie
    Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    When Uzytkownik wpisuje <nazwaUzytkownika> username
    And Uzytkownik wpisuje <haslo> w pole password
    And Uzytkownik kilka przycisk Login
    Then Uzytkownik nie zostaje zalogowany

    Examples:

      | nazwaUzytkownika | haslo  |
      | tomsmith         | blabla |
      | tomsmith         | aaaa   |