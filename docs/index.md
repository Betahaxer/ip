---
layout: default
title: Home
---

# User Guide for **Bond's Mission Tracker**

Welcome to **Bond's Mission Tracker**, your new partner in staying ahead of the game! Just like Bond himself, this tool
will help you complete your missions efficiently and precisely, whether you're tracking deadlines or managing those
pesky to-dos. Stay organized, stay sharp, and always be on top of your assignments.

---

## Quick Start

1. Ensure you have the Java 17 or above installed in your computer.
2. Download the latest version of Bond from [here](https://github.com/Betahaxer/ip).
3. Navigate to the folder where you saved the application and run the following command:\
   `java -jar bond.jar`
4. Bond will greet you with a welcome message upon starting. Welcome to Bond!
5. To start, type the command in the command box and press Enter to execute it. e.g. typing `list` and pressing `Enter`
   will list all the missions in your task list.\
   Some example commands you could try:
    * `list`: Lists all missions
    * `todo read book`: adds a todo mission with a description of `read book `
    * `delete 2`: deletes the 2nd mission shown in the tasklist
    * `bye`: Exits Bond
6. Refer to [Features](#features) below for details of each command.

---

## Features

### 1. **Adding Missions**

Bond's Mission Tracker supports three types of missions: **Todo**, **Deadline**, and **Event**.

#### Add a Todo Mission

For those missions that have no deadline but must be done.

**Format:**

```
todo DESCRIPTION
```

**Example:**

```
todo Go for Walkies
```

**Output:**

```
[T][ ] Go for Walkies
```

---

#### Add a Deadline Mission

For those missions that have a time-sensitive deadline.

**Format:**

```
deadline DESCRIPTION /by DATE_TIME
```

**Example:**

```
deadline Deliver intel /by 31st December 2359
```

**Output:**

```
[D][ ] Deliver intel (by: 31st December 2359)
```

---

#### Add an Event Mission

For missions with a specific start and end time.

**Format:**

```
event DESCRIPTION /from START_DATE_TIME /to END_DATE_TIME
```

**Example:**

```
event Secret briefing /from 1st Jan 9:00am /to 1st Jan 11:00am
```

**Output:**

```
[E][ ] Secret briefing (from: 1st Jan 9:00am to: 1st Jan 11:00am)
```

---

### 2. **Viewing Missions**

#### List All Missions

View all your current missions.

**Format:**

```
list
```

**Output:**

```
Hmph... The future is uncertain, but these tasks must be completed:
1. [T][ ] Go for Walkies
2. [D][ ] Deliver intel (by: 31st December 2359)
3. [E][ ] Secret briefing (from: 1st Jan 9:00am to: 1st Jan 11:00am)
Woof 3 tasks… I see them all… woof
```

---

#### Find Missions by Keyword

Search for specific missions using a keyword.

**Format:**

```
find KEYWORD
```

**Example:**

```
find Walkies
```

---

### 3. **Marking Missions**

#### Mark a Mission as Complete

Seal the deal—mark a mission as completed.

**Format:**

```
mark INDEX
```

- `INDEX` refers to the task number shown in the list.

**Example:**

```
mark 1
```

**Output:**

```
Wag wag! This task is done now! Good job, human!
[T][X] Go for Walkies
```

---

#### Mark a Mission as Incomplete

Need to redo a mission? Mark it as incomplete.

**Format:**

```
unmark INDEX
```

**Example:**

```
unmark 1
```

**Output:**

```
Awooo... This task isn't done anymore! Try again later?
[T][ ] Go for Walkies
```

---

### 4. **Deleting Missions**

#### Delete a Mission

When a mission is no longer needed, simply remove it.

**Format:**

```
delete INDEX
```

**Example:**

```
delete 1
```

**Output:**

```
Woof! Task 1 has been removed. Hope it wasn't a snack!
```

---

### 5. **Exiting the Tracker**

When you're done tracking, exit with grace. This would also save the missions.

**Format:**

```
bye
```

**Output:**

```
Woof. Hope to see you again soon!
```

---

## Command Summary

| Command      | Format                                                      |
|--------------|-------------------------------------------------------------|
| **Todo**     | `todo DESCRIPTION`                                          |
| **Deadline** | `deadline DESCRIPTION /by DATE_TIME`                        |
| **Event**    | `event DESCRIPTION /from START_DATE_TIME /to END_DATE_TIME` |
| **List**     | `list`                                                      |
| **Find**     | `find KEYWORD`                                              |    
| **Mark**     | `mark INDEX`                                                |
| **Unmark**   | `unmark INDEX`                                              |
| **Delete**   | `delete INDEX`                                              |
| **Exit**     | `bye`                                                       |

---

## FAQ

**Q: Will my tasks be saved?**  
A: Yes. Tasks are saved automatically upon exiting in file named `Tasks.txt`. There's no need to manually save anything.

**Q: Can I modify a task once it's added?**  
A: Currently, Bond's Task Tracker doesn't allow direct editing of tasks. However, you can delete and re-add the task
with the updated information.

**Q: What happens if I close the app without typing `bye`?**  
A: Don't worry—your tasks will be preserved. However, it’s recommended to use the `bye` command to ensure a smooth exit.

---

Enjoy using **Bond's Mission Tracker**, where no mission is left behind! If you need assistance, reach out and we'll be
right
by your side, just like any good partner would.
