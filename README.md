<img align="left" src="http://skilldistillery.com/downloads/sd_logo.jpg">

### Aaron Cottrell &nbsp;Jourdan Rentschler &nbsp;David Daniels
<br>

# Spring MVC Film C.R.U.D. Project

## Overview
Use SpringMVC to interact with MYSQL database on a hosted site.

## Step by Step (Short Version)
1. Landing Page index.html
2. Choose desired option from button list
3. Fill in search or new input information
4. View search results
5. Option to edit/delete returned information.
6. Confirmation of user action

## Walkthrough (Long Version)
On initial site launch, the user is prompted to specify whether to Add or Search a Film.
<img align="right" src="images/Screen Shot 2020-10-19 at 1.27.30 AM.png"  width="227" height="175">
Adding a film is fairly straightforward as there needs to only not be invalid input in any of the data or text fields to "in theory" create a film entry. When an entry is successfully input. The user is navigated, via re-route to avoid duplicate submission, to a confirmation page.

The Film ID Search page allows for more pinpoint search results. A user will have the ability to search by Film ID. If a film is identified in the database all film and actor information is displayed.

The Search By Keyword page will move the program into the prompt for search keyword. The program will then create a search algorithm from the user input which allows the program to sift through the database for matching data from the film title or description. If no data is matched in the search, the program will display that no results were found. If one or more films matched with the search, each film will be displayed with associated details and options to update or delete. The program will also keep a count of the number of search results returned.

Choosing to update a given entry will navigate to an update page where entry fields are automatically populated and the user is able to manage each field as they wish. Upon successful update the user is navigated to a confirmation screen.

Once the search has completed or on any the user may choose to go to the home page. This will discard any un-submitted changes to the database.

The user can exit at any point by exiting out of their browser tab.

## Struggles
####Jourdan Rentschler:
Some of the struggles I had faced on this project was the planning process.
I forgot how important it was to sit down and map out how things were going to go.
I started to panic in the beginning to figure out how to connect all the dots and using the ORM and the ERD.
I liked that i was able to work on the .jsp's and playing around with more of the webby stuff.
It also was really cool to work with Aaron after I had created the .jsp's then he would set the Controller to call on that.
Seeing how important the Controller and the DAOImpl is all incorporated was really awesome to see it all come together.
It also really gave us more exposure of the start to finish process of building an application. A lot of moving parts and that previous week we learned a lot of information so I felt a little nervous on this project because I wasn't sure we would have a lot of time. The other thing i struggled with was figuring out who was going to do what... trying to break it down by user story or by front end, back end work.

####Aaron Cottrell:
Working with GET and POST Methods within the Controller. Knowing when to request a parameter and when not to. So many small details to get wrong at this point. Errors and more errors. Time Zone for the SSL statement one was a doozy. I am still pretty hopeless when it comes to HTML formatting so thank goodness for Jourdan & David working on those parts of the JSP files for us and at least now I have some templates to work off of. UML-like planning probably would have been helpful. We probably also could have benefitted from writing J-unit test methods so that we didn't need to test the site on server over and over again. I'm still not really sure on how to write those tests when the return is a ModelandView object.

Getting a fully working site took longer than normal but there was so much to work through. I know all of us had more ideas for functionality that got set aside due to the amount of time it took us to get through the end of the main user stories.


####David Daniels:
Biggest struggle I had was getting stuck on the update film method in the DAOImpl. Was certainly a learning experience seeing how it was not working correctly and then changing things only to see it still not working correctly. Eventually with some help it was all figured out. Asking for help and communication with others are still not my strengths, both things I hope to get better at. There was a merge conflict at the very end of the project that has caused me to have some fights with git. Hoping to understand this a bit more as we continue to work in groups.


## Lessons Learned
####Jourdan Rentschler:
I learned a lot on COMMUNICATION with our teammates! I think we did a great job of letting each other know who was working in what file so we wouldn't have any merging issues. Learned a lot about the pull and push and how important that is when working in a group. Also, I learned a lot more on how to read exceptions and error messages and where to look in your code to fix those errors. Also, ALWAYS refresh Gradle and your Project!

####David Daniels:
Some lessons learned were that git can be a bit annoying when working with multiple people because of the merge conflicts and such. We did not really run in to too many issues luckily but did have to get used to communicating with everyone on what file we were working in or when we were making pushes.
Learned a lot about how all of the different files work together. How the DAOImpl, Controller, and jsp's all come together was just kind of reinforced on this project. I am still struggling with communicating my ideas that are in my head into words as to explain them to teammates. I can sit down and tinker with things and break them and make them work but communicating it into words is something I need to get better at.

####Aaron Cottrell:
I learned a lot about certain Stacktrace errors and what they mean. They became easier and easier to fix as the project went along. Patience was big on this one. I'm used to being able to sit down and mash keys until the projects are complete. This was a step in waiting for someone else to get the changes in that you might need in order to test the connection. More real world. We managed to have a pretty good plan of attack on avoiding Git issues until the very end when David and I were both trying to fix an issue with the update sql statement and things got hairy on David's end for pulling due to a merge error we were unable to solve. As of submission time, we were still unable to get his side to pull but Jourdan and I still have push and pull capabilities so I think that's a win for the first collab project.

## New Course Material
1. Gradle
2. SpringMVC
3. Github Group Collaboration
4. JSP files
5. Controllers
6. Annotated DAO
7. TOMCAT
8. C.R.U.D
9. Bootstrap
