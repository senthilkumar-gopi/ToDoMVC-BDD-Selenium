@regression
Feature: Manage my todo list
In order to remember the things I want to do,
As an ToDo MVC user, I want to manage my todo list

Background:
	Given Senthil opens the todoMVC application
	
	@test_01
    Scenario Outline: Add new tasks
    In order to remember what tasks need to do for this month
  	As a todoMVC user, Senthil adds the list of tasks to the Todo items
	When Senthil add task "<taskname>" to the TODO list
	Then Senthil ensure task "<taskname>" is listed in "Active" section
	And Senthil ensure task "<taskname>" is listed in "All" section
	And Senthil ensure task "<taskname>" is not listed in "Completed" section
	
	Examples:
	|taskname        |
	|Machine Learning|
	|RPA             |
	
	@test_02
    Scenario Outline: Edit existing tasks
    In order to remember the tasks to be completed for this month
  	As a todoMVC user, Senthil wanted to edit the already existing task
  When Senthil add task "<oldtask>" to the TODO list
	Then Senthil ensure task "<oldtask>" is listed in "Active" section
	When Senthil edit task "<oldtask>" from the list with new Task "<newtask>"
	Then Senthil ensure task "<newtask>" is listed in "Active" section
	And Senthil ensure task "<newtask>" is listed in "All" section
	And Senthil ensure task "<oldtask>" is not listed in "Active" section
	And Senthil ensure task "<oldtask>" is not listed in "All" section
	
	Examples:
	|oldtask         |newtask      |
	|Machine Learning|Deep Learning|
	
	@test_03
	Scenario Outline: Verify Dashboard count with items displayed
    In order to verify items count,
    As a todoMVC user, Senthil wanted to complete some tasks and verify the count with displayed count
	When Senthil add task "<taskname1>" to the TODO list
	And Senthil add task "<taskname2>" to the TODO list
  And Senthil add task "<taskname3>" to the TODO list
  Then Senthil ensure 3 items left
	When Senthil marks the task "<taskname1>" as Completed
	Then Senthil ensure task "<taskname1>" is striked off
	And Senthil ensure 2 items left
	When Senthil marks the task "<taskname2>" as Completed
	Then Senthil ensure task "<taskname2>" is striked off
	And Senthil ensure 1 items left
	
	Examples:
	|taskname1       |taskname2    |taskname3|
	|Machine Learning|Deep Learning|RPA      |
	
	@test_04
	Scenario Outline: Complete single Task
    In order to mark complete the existing tasks
    As a todoMVC user, Senthil wanted to close existing tasks as completed
	When Senthil add task "<taskname>" to the TODO list
	Then Senthil ensure task "<taskname>" is listed in "Active" section
	When Senthil marks the task "<taskname>" as Completed
	Then Senthil ensure task "<taskname>" is striked off
	And Senthil ensure task "<taskname>" is listed in "Completed" section
	And Senthil ensure task "<taskname>" is not listed in "Active" section

	Examples:
	|taskname        |
	|Machine Learning|
	
	@test_05
	Scenario Outline: Clear already completed tasks
    In order to clear the already completed tasks
    As a todoMVC user, Senthil wanted to clear the already completed tasks
	When Senthil add task "<taskname1>" to the TODO list
	And Senthil add task "<taskname2>" to the TODO list
	Then Senthil ensure task "<taskname1>" is listed in "Active" section
	And Senthil ensure task "<taskname2>" is listed in "Active" section
	When Senthil marks the task "<taskname1>" as Completed
	Then Senthil ensure task "<taskname1>" is striked off
	When Senthil clicks Clear completed link
	Then Senthil ensure task "<taskname1>" is not listed in "Completed" section
	And Senthil ensure task "<taskname1>" is not listed in "All" section
	And Senthil ensure task "<taskname1>" is not listed in "Active" section

	Examples:
	|taskname1       |taskname2    |
	|Machine Learning|Deep training|
	
	
  @test_06
	Scenario Outline: Complete All Tasks
    In order to mark all the tasks as completed
    As a todoMVC user Senthil
    Senthil wanted to mark all tasks in the TODO list as completed
	When Senthil add task "<taskname1>" to the TODO list
	And Senthil add task "<taskname2>" to the TODO list
	Then Senthil ensure task "<taskname1>" is listed in "All" section
	And Senthil ensure task "<taskname2>" is listed in "All" section
	When Senthil clicks toggle all Tasks
	Then Senthil ensure task "<taskname1>" is striked off
	And Senthil ensure task "<taskname2>" is striked off

	Examples:
	|taskname1       |taskname2    |
	|Machine Learning|Deep training|
	