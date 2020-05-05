# CiviVPlanner

---------------------------------------------------------------------

  1.      Documentary
  
  2.      Implemented features
  
  2.      How to use (Can also be found withing the app)
  
---------------------------------------------------------------------



        1. Documentary



Practice assignment in object-oriented programming

    The program is called CiviVPlanner. It is an application developed to support Civilization 5 videogame players
    and allows users to publish and browse plans intented to better their game. These plans include the technology
    and social policy choices that will determine the progress of the game, the chosen ideology, the victory condition, and a
    description and a name. In order to use the program, the user must register as a user of the application, after
    which the login is done automatically, unless the user himself wants to log out. After logging in, the user must enter
    a 6-character set of characters to identify themselves. When browsing plans, users also have the ability to rate plans
    published by others.

    I did the work alone, meaning it was on my account to design everything from the database to the user-interface. I initially
    designed the program with class diagrams and visualization of transition situations, on the basis of which I began
    to build the program. I started with the implementation of a database, which was one of the first stumbling blocks
    of the project. I didn’t have any foreknowledge of databases, and it was a big job to start learning even some
    kind of database implementation while doing other features of the project. I ended up using Firebase Realtime Database
    in my work, which seemed like an effective option. Here, however, problems also arose, which I then spent several days
    fixing. When I got the database up and running, I did a simple login and registration process for the app. After that,
    I started to develop the application in the order in which the application is intended to be used: new plan, choice of
    victory type, building the technology and policy paths, making a description, naming the plan, browsing plans, rating plans
    filtering, etc. In my opinion, I came up with a pretty smart way of transfering data between activities,
    where the plan information is put into an object and this object is then transferred between activities using serialization.
    This, in my opinion, avoided unnecessary writing to files, and since I did not find any specific disadvantages of this
    method even after a brief study, I implemented it. When I got the core functions of the program to work, I redesigned its
    graphical user interface and designed a *nice* logo for it. After that, I added some features that I was yet to add to the program,
    such as deleting plans, writing and reading to a file, minimum password requirements, and verification when logging in.




        2.  Implemented features (for project grading)
        
        


Basic features:

    - Object-oriented programming

    - At least five classes & objects

    - Write and read data from a file in CSV format.

    - Topic-specific basic functions (found below)



Additional Functions:

    - Well-designed and user-friendly UI components2p

      (e.g. recyclerview-cardview view)

    - Database

    - Multiple users and data storage

    - Signing in and registering new users

    - Password protection

    - Good password requirements and user verification


Topic specific functions:

    - Presenting user information

    - Creating and publishing own plans

    - Can browse and view plans produced by others

    - Possible to evaluate the plans of others

    - The user can delete their own plans

    - Plans can be filtered by desired victory condition while browsing them

    - ‘About’ activity with a brief description of the program and instructions

    - Neat logo



        3. How to use
        
  
        
    The app is easy to learn and linear in it's way of use. User must first register
    an account. This is pretty straightforward, but for anyone concerned the app doesn't
    send any kind of spam email or such even though it requires an email to register.
    After creating an account the user must verify her/himself by typing a 6-character
    randomly generated string of characters. The user is then taken to the main screen where
    the next choice of action is made. The main screen also presents the user with his/her
    username and userID.
 
    New plan:
    
    The user is taken through a linear process of creating a new gameplay plan. First the
    user must choose a victory condition of choice. Next comes the technology path. Here
    the user can add entries to the plan's technology list by clicking any entry within
    the recyclerview, and then picking technologies from the view familiar from the game.
    After choosing, the user can return to the recyclerview by clicking the return button
    on the top-left of the screen. Before proceeding, the user can delete entries or add more
    if he/she so desires.
    Clicking next will take user to choose the plans' policy path. This is similar to choosing
    technologies. Just clicking any policy will add it to the plan, and the policy's order is
    then represented with a number. After choosing policies, the user must choose an ideology
    to proceed.
    Now it's time to fill the project's description. It's advised to add how different starts
    affect player choices, and what technologies/buildings/wonders are top priority. In the end,
    the plans' creator is free to choose how the plan is supposed to be interpreted as.
    Next comes naming the plan. This is pretty straightforward. Clicking 'submit' will send the
    plan to the database and for all users to see and rate.
    
    Browse plans:
    
    Here the user can browse all plans submitted by other users and rate them. User can see the plans'
    score and inspect any plan by tapping on an entry. While inspecting a specific plan, the user can
    take a look at the plans' technology or policy paths by tapping the relevant button. While inspecting
    a culture path, different policy families are differentiated by color. Plans' ideology and victor
    condition are also shown, and represented as images. If you're having trouble interpreting these
    pictures, here's a quick guide. These should however be familiar from the game.
    
        Ideologies:
              Torch = Freedom
              Fasces = Autocracy
              Hammer and sickle = Order
        Victory conditions:
              Blue vial = Science
              Nuke blast = Conquest
              Handshake = Diplomacy
              Paper and quill = Culture
          
     The plans' owner has the choice of deleting his own plans. Even though the deletion button is present for
     everyone, others can't interact with it and will be presented with a notification about this.
     
     About:
     
     The about page includes a short version of the documentary and userguide found here.
    
    


