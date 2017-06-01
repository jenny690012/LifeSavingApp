Life saving app is a term project which I worked with other two teammates.
Unfortunately, I do not have the complete code of the entire project.
In this repository I only include the work of my contribution, which is a
native GUI of our android app named "myApplication". 
The pdf files are progress reports of the projects.


when you run "myApplication" on your device, you will see a link called
"how to use", you can click on it to see the full instruction of how to 
use this app. 

To implement is GUI, I used singleton partern. There is a singleton exits 
through out the application life. The GUI consist  lots of ativities and
 intents. and each activities will trigger an action
to do some update to this singleton. 

The benefit of using singleton is that
data will always available no matter what happens with activites. Also, the
choice of singleton makes it easy for my teammate to wire their code 
with mine without understand how the view and controller parts of GUI works.
To wire up client side with server side, my teammate just need to implement
some functions within "UserProfile.java". These functions will inflates the
singleton with information from the server, or sends current information
within singleton to the sever. Because I do not have the completed code, those 
functions are left unimplemented. 
