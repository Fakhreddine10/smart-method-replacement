# smart-method-replacement
During my experience at ENEDIS-France as Software Engineer, I've faced many problems, sometimes the client change the rules periodically,and we've worked with Scrum as methodology so in this case we are obliged to change the code implementation for certain method. 

The problem is : Delete code, write new one after two months, and after a few months later we can  delete another  code and write another new one and maybe we will write a new code for a rule  which we have a code written in the past.

STOP, Wait, WTF, what are you doing? why we are not keeping the code and write a new one and choose a specific implementation at runtime !!!!! 

This is a great Idea, so the solution is: 
To write the code which will replace the previous implementation of the method and at runtime we should decide which method implementation will be invoked.
