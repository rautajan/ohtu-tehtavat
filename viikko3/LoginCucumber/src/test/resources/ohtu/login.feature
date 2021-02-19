Feature: User can log in with valid username/password-combination

    Scenario: user can login with correct password
       Given command login is selected
       When  username "pekka" and password "akkep" are entered
       Then  system will respond with "logged in"
       
    Scenario: user can not login with incorrect password
       Given command login is selected
       When  incorrect password "pekka" and username "pekka" are entered 
       Then  system will respond with this message: "wrong username or password"

    Scenario: nonexistent user can not login to 
       Given command login is selected
       When  nonexistent username "maija" and password "ajiam" are entered
       Then  system will respond with error message: "wrong username or password"
