## Introduction to Testing

Software testing is an important part of the software development process. Without it, you can't be sure that what you write works until it's already seeing real users. The objective of this lesson is to demonstrate the fundamentals of unit testing using ”JUnit” and ”Mockito” frameworks. In the first few concepts, we’ll introduce you to the software testing, in general. In the rest of the concepts, we'll look at unit-testing in depth and show you how to effectively write unit-test cases.

### What is Testing?

Testing means verification of the functionality of your application and make sure that all the parts work together exactly as they should. It essentially ensures that the application is bug-free and behaves correctly in as many scenarios as possible. Without it, bugs would be everywhere. The video goes over a few high profile cases where testing would have prevented massive, costly failures. Hopefully, after watching it you will gain an appreciation of the importance of good testing procedures.

___
### What is Software Development Life Cycle (SDLC)?

![Alt text](java/SDLC.png?raw=true "SDLC")

The __Software Development Life Cycle__ (or **SDLC**) is a series of processes used to develop projects. Each phase of SDLC produces deliverables required by the next phase of the project cycle. Testing is one such deliverable that should be performed on a developed product based on the product requirements.

There are different SDLC models, such as Waterfall model, Iterative model, and Spiral model. These are the conventional models used for software development. These models differ in the number of iterations, the number of stages, and the deliverable of each stage.

#### Few Famous SDLC Models

##### Waterfall Model

This conventional SDLC model has the following six stages: requirement gathering, design, built, test, deploy, and maintain. Each stage must be completed before moving to the next stage. Hence, verification and validation are performed after each stage, along with elaborative documentation. This model is suitable for smaller projects because bugs (if any) can only be fixed within a stage. This model is not preferable where requirements change frequently. The testing stage comes a little late in this model. So it is expensive to make changes in the software built.

##### Agile Software Development

There is another sub-category of SDLC, called Agile Software Development. This category of models has an adaptive approach to developing software. Here, the requirements and corresponding solutions evolve collaboratively. It needs periodic interactions between all stakeholders, incremental development, better customer-collaborations, and easy to accommodate the requests for change. A few famous models under the Agile category are Extreme Programming (XP), Scrum, and Kanban. Agile models work on the customer-centric principles, as mentioned here.

##### Test-driven development (TDD)

Test-driven development (TDD), is an evolutionary approach to development which combines test-first development where you write a "test'' first. Later, you write the necessary development code to fulfill that test. It is the combination of test-first development and correspondingly refactoring the code. TDD makes it easier to conform to the requirements. Thediagram below presents the whole process of TDD:

![Alt text](java/≈.png?raw=true "SDLC")

##### What is special about Agile Software Development that makes it more popular as compared to traditional SDLC models?

    It is popular because the Agile model offers more periodic interactions with all stakeholders, incremental development, better customer-collaborations, and easy to accommodate the requests for change. 
    
![Alt text](java/Environment.png?raw=true "Development, Test, and Production Environments")

___

### Types of Software Testing

In this concept, we would have a brief introduction to different types of software testing and dig deeper into Unit testing. Software testing is broadly divided into the following types - Functional, Non-Functional, and Maintenance testing, as described below:


* __Functional testing__ is usually performed by the Quality and Development team and sometimes Business. Functional testing includes unit testing, integration testing, system testing, sanity testing, UAT(user acceptance testing) testing, regression, amongst others.
* __Non-Functional testing__ is performed by specialized testing teams. Non-functional testing includes performance testing, load testing, stress testing, security testing, reliability testing, usability testing, compliance testing, amongst others.
* __Maintenance testing__ is performed on already deployed softwares. It includes regression testing, and confirmation testing. The need for maintenance testing arises when a software undergoes some addition/change in functionality.

![Alt text](java/Types_of_Testing.png?raw=true "Types of Testing")

#### Unit Testing

__Unit testing__ is the process of testing an individual, usually small, software module or component independently to find bugs. These tests are required to be written by the developers as it requires detailed knowledge of the code.

![Alt text](java/Testing.png?raw=true "Types of Testing")

