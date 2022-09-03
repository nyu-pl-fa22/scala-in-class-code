### Installing the Scala Tool Chain

We will provide support and instructions for OSX and Linux (Ubuntu).

If you have a system running Windows, we suggest to follow the instructions [below](#installing-ubuntu-on-windows-windows-only) to install Ubuntu using Windows Subsystem for Linux. Then follow the Ubuntu instructions for the installation of the tool chain. Alternatively, you can also install the Scala tool chain directly under Windows. Though, we will not be able to provide support for this setup.


#### Installing Ubuntu on Windows [Windows only]

If you are using Windows 10 or newer, proceed as follows. Install Ubuntu via the Windows Subsystem for Linux (WSL) following the instructions in these tutorials:

* [Install Linux on Windows with WSL](https://docs.microsoft.com/en-us/windows/wsl/install)

* [Run Linux GUI apps on the Windows Subsystem for Linux](https://docs.microsoft.com/en-us/windows/wsl/tutorials/gui-apps)

Follow the second tutorial above to install Google Chrome or some other web browser of your choice within your WSL Ubuntu subsystem. 
Then follow the installation instructions for Ubuntu below and install everything within your Ubuntu subsystem. In particular, install Intelij Idea within the Ubuntu subsystem rather than as a Window app. To do this, start the web browser from the command line of your Ubuntu subsystem and then Download Intelij as outlined below. Downloaded files will be stored in the directory `~/Downloads`.

If you are using an older Windows version or as an alternative to the above, you can install a Ubuntu virtual machine using VirtualBox and follow the instructions for Ubuntu. VirtualBox is free. Instructions can be found [here]( http://www.psychocats.net/ubuntu/virtualbox).

** Make sure to give your system plenty of disk space, at least 30 GB, if possible. Don't worry VirtualBox will only actually use what it needs.

Once you've followed the above instructions, start the VM. Open the Devices menu option and click 'Insert guest additions CD image.' You will be prompted to run some software from that image. Follow the instructions and install the guest additions. This will give you better screen resolution.

#### Homebrew [OSX only] 
 
Homebrew is a package manager for OSX, which makes installing development software much easier. We will use it to install Sbt. You will find it useful in the future for install of other things as well.

* [OSX] Install using the instructions [here](http://brew.sh/)

#### XCode [OSX only]

XCode is a development environment for Macs. We will not be using it, but installing it installs a number of useful Unix command line tools. 

* [OSX] Install the most recent version of XCode from [here](https://developer.apple.com/xcode/downloads/)

#### Git

* [Ubuntu] Git is pre-installed on Ubuntu.
* [OSX] From terminal: ```brew install git```
* You can test the install of git on your system by running the command `git` from terminal. You should see usage information.
* Finally run the following commands from terminal:<br>
   ```git config --global user.email "your@email.com"```<br>
   ```git config --global user.name "Your Name"```<br>
   (The email should be the same email you used to register your github account)

Here are some Git-related resources:
* If you are unfamiliar with Git, watch the [first two git basics video](http://git-scm.com/videos).
* If you are unfamiliar with Github, watch [this YouTube video](https://www.youtube.com/watch?v=0fKg7e37bQE).
* A [simple git cheatsheet](http://rogerdudler.github.io/git-guide/).
* A [complete reference](http://www.git-scm.com/book/en/v2).
* I suggest using the command line or the IntelliJ integration to interact with Git, but in a pinch [this GUI](https://desktop.github.com/) might be useful.

#### Java Development Kit

We will need the Java Development Kit (JDK) to run Sbt and Scala programs.

* [Ubuntu] From terminal: ```sudo apt install default-jdk```
* [OSX] From terminal: ```brew cask install java```

#### Scala and Sbt

We will be using [Scala](http://www.scala-lang.org/) for most programming assignments throughout this course. We standardize to version 3.1.3 of the Scala language. The installation of the correct Scala version as well as any libraries that our code will depend on is handled through sbt. 

sbt is an open source build tool for Scala projects, similar to Maven or Ant. More information can be found [here](https://en.wikipedia.org/wiki/SBT_%28software%29). (You will need this to do the homework assignments)

* [OSX]  From terminal: ```brew install sbt```
* [Ubuntu] From terminal:<br> 
  ```bash
  echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list
  echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | sudo tee /etc/apt/sources.list.d/sbt_old.list
  curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
  sudo apt-get update
  sudo apt-get install sbt
  ```
  If `curl` is not already installed on your system, then first run `sudo apt-get install curl`.
* Confirm success by running the command from terminal: 
    ```sbt    ```
    (sbt should start. Use `Ctrl+d` to quit or type `exit`.)

** More detailed instructions can be found [here](http://www.scala-sbt.org/release/tutorial/Installing-sbt-on-Linux.html).

#### IntelliJ Idea

We will be using the [IntelliJ Idea Java IDE](https://www.jetbrains.com/idea/). It is what we will use in class. And we will be demonstrating development techniques with this IDE that will make your life easier. If you prefer to use a different IDE, go for it. Essentially, any IDE that provides Scala/sbt integration should work. Though, we will only provide support for IntelliJ Idea.

To install IntelliJ Idea, proceed as follows:

* Sign up for [free student licenses](https://www.jetbrains.com/shop/eform/students) (Reminder: use your NYU email)
* In the meantime, download the [Ultimate Edition Free 30-day trial](https://www.jetbrains.com/idea/download/) of Intellij.
* [Ubuntu] Untar the downloaded archive by clicking it and then using the "Extract" menu item. Extract to location of your choice. Open that location and follow the instructions inside the "Install-Linux-tar.txt" file.
* [OSX] Open the disk image and use the installer.
* When prompted, select "Evaluate for 30 days". Install the license when you get them in an email from Jetbrains.
* During the "Customize" phase on the "*Featured* plugins screen",
  select and install the 'Scala' plugin. It should be in the top left
  corner of this screen. This is necessary to get sbt integration and
  Scala support in Intellij.
* For reference, here is a link to the [Intellij documentation](https://www.jetbrains.com/idea/help/basic-concepts.html).

There are many many free plugins available for Intellij. You should feel free to install anything that sounds useful to you. You can explore what is available from the "Preferences" menu in Intellij.


### Importing a Scala sbt Project into Intellij

To import the Scala sbt project for the in-class-code into Intellij, do the following:

* Open Intellij and proceed with one of the following two options:

  Option 1:
   
  * Click the "Open" menu item. You can do this either from the splash screen after opening Intellij or if you skip the spash screen by choosing "Open" in the "File" submenu of the main menu at the top.
    
  * Navigate to your cloned repository and select the "scala-in-class-code"
    directory and click "OK".
  
  * Click the radio button "Open as: sbt project", then click "OK".

  * Click "Trust Project".

* It may take IntelliJ a few minutes to initialize the project. Future
  project imports will be faster.

* If you are prompted with a message like "Unregistered VCS root
  detected", simply click "Add root".

* Open the worksheet `src/main/scala/pl.class03/worksheet.sc` and type in some Scala
  expressions. Alternatively, start the Scala REPL by
  typing `console` in the sbt shell. If the sbt shell is not already
  open, you can open it by pressing Crtl+Shift+s [Ubuntu] or
  Command+Shift+s [OSX].

* Post on Brightspace if you need help, most likely others have had the
  same problem and may have figured it out.


### Scala Basics

In the following, we assume that you have started the Scala
REPL. Though, (almost) all of these steps can also be done in a Scala
worksheet.

#### Expressions, Values, and Types

After you type an expression in the REPL, such as `3 + 4`,
and hit enter:

```scala
scala> 1 + 2
```

The interpreter will print:

```scala
val res0: Int = 3
```

This line includes:

* an automatically generated name `res0`, which refers
  to the value resulting from evaluating the expression,
* a colon `:`, followed by the type `Int` of the expression,
* an equals sign `=`,
* the value `3` resulting from evaluating the expression.

The type `Int` names the class `Int` in the
package `scala`. Packages in Scala partition the global
name space and provide mechanisms for information hiding, similar to
Java packages. Values of class `Int` correspond to values of
Java's primitive type `int` (Scala makes no difference
between primitive and object types). More generally, all of Java's
primitive types have corresponding classes in the `scala` package.

We can reuse the automatically generated name `res0` to
refer to the computed value in subsequent expressions (this only works
in the REPL but not in a worksheet):

```scala
scala> res0 * res0
val res1: Int = 9 
```

Java's ternary conditional operator `? :` has an equivalent in Scala,
which looks as follows:
```scala
scala> if res1 < 10 then res0 - 5 else res0 + 5
val res2: Int = -2
```

In addition to the `? :` operator, Java also has if-then-else
statements. Scala, on the other hand, is a functional language and
makes no difference between expressions and statements: every
programming construct is an expression that evaluates to some
value. In particular, we can use if-then-else expressions where we
would normally use if-then-else statements in Java.
```scala
scala> if res1 > 2 then println("Large!") 
       else println("Not so large!")
Large!
```

In this case, the if-then-else expression evaluates to the value `()`,
which is of type `Unit`. This type indicates that the sole purpose of
evaluating the expression is the side effect of the evaluation (here,
printing a message on standard output). In other words, in Scala,
statements are expressions of type `Unit`. Thus, the type `Unit` is
similar to the type `void` in Java, C, and C++ (which however, has no
values). The value `()` is the only value of type `Unit`. 

Note that if an expression evaluates to `()`, then the result value
and type are not printed by the REPL. In the example above, it only
prints `Large!`, which is the side effect of evaluating the
expression.

The following example shows that the expression indeed returns `()`.

```scala
scala> val u = if res1 > 2 then println("Large!") else println("Not so large!")
Large!

scala> u == ()
val res3: Boolean = true
```


#### Names

We can use the `val` keyword to give a user-defined name to
a value, so that we can subsequently refer to it in other expressions:
```scala
scala> val x = 3
x: Int = 3
scala> x * x
res0: Int = 9
```
Note that Scala automatically infers that `x` has type
`Int`. Sometimes, automated type inference fails, in which
case you have to provide the type yourself. This can be done by
annotating the declared name with its type:
```scala
scala> val x: Int = 3
val x: Int = 3 
```
A `val` is similar to a `final` variable in
Java or a `const` variable in JavaScript. That is, you cannot reassign it another value:
```scala
scala> x = 5
-- [E052] Type Error: ----------------------------------------------------------
1 |x = 5
  |^^^^^
  |Reassignment to val x
  |
  | longer explanation available when compiling with `-explain`
1 error found
```
Scala also supports mutable variables, which can be
reassigned. These are declared with the `var` keyword
```scala
scala> var y = 5
y: Int = 5
scala> y = 3
y: Int = 3
```
The type of a variable is the type inferred from its initialization
expression. This type is fixed. Attempting to reassign a variable to a
value of incompatible type results in a type error:
```scala
scala> y = "Hello"
-- [E007] Type Mismatch Error: -------------------------------------------------
1 |y = "Hello"
  |    ^^^^^^^
  |    Found:    ("Hello" : String)
  |    Required: Int
  |
  | longer explanation available when compiling with `-explain`
1 error found
```

#### Functions

Here is how you write functions in Scala:

```scala
scala> def max(x: Int, y: Int): Int = {
         if x > y then x
         else y
       }
def max(x: Int, y: Int): Int
```

Function definitions start with `def`, followed by the
function's name, in this case `max`. After the name comes a
comma separated list of parameters enclosed by parenthesis, here
`x` and `y`. Note that the types of parameters
must be provided explicitly since the Scala compiler does not infer
parameter types. The type annotation after the parameter list gives
the result type of the function. The result type is followed by the
equality symbol, indicating that the function returns a value, and the
body of the function which computes that value. The expression in the
body that defines the result value is enclosed in curly braces.

If the defined function is not recursive, as is the case for
`max`, the result type can be omitted because it is
automatically inferred by the compiler. However, it is often helpful
to provide the result type anyway to document the signature of the
function. Moreover, the curly braces can be omitted. Thus, we
could alternatively write the function max like this:

```scala
scala> def max(x: Int, y: Int) = if x > y then x else y
def max(x: Int, y: Int): Int
```

Once you have defined a function, you can call it using its name:
```scala
scala> max(6, 3)
res3: Int = 3
```

Naturally, you can use values and functions that are defined outside of a function's body in the function's body:
```scala
scala> val pi = 3.14159
pi: Double = 3.14159

scala> def circ(r: Double) = 2 * pi * r
def circ(r: Double): Double
```

You can also nest value and function definitions:
```scala
scala> def area(r: Double) = 
         val pi = 3.14159
         def square(x: Double) = x * x
         pi * square(r)
def area(r: Double): Double
```

Recursive functions can be written as expected. For example, the
following function `fac` computes the factorial numbers:
```scala
scala> def fac(n: Int): Int = if n <= 0 then 1 else n*fac(n-1)
def fac(n: Int): Int

scala> fac(5)
res4: Int = 120
```

#### Scopes

Scala's scoping rules are similar to Java's:

```scala
val a = 5
// only a in scope
{
  val b = 4
  // b and a in scope

  def f(x: Int) = 
    // f, x, b, and a in scope
    a * x + b 
    
  // f, b, and a in scope
  f(b)
}
// only a in scope
```

There are some differences to Java, though. Scala allows you to redefine
names in nested scopes, even if that name has already been bound in
an outer local scope:
```scala
val a = 3;
{
  val a = 4 // hides outer definition of a
  a + a     // yields 8
}
```
However, as in Java, you cannot redefine a name in the same scope:
```scala
  val a = 3
  val a = 4 // does not compile
```
Also, unlike in Java, you can't refer to a name before it is bound in
the same block, even if that name has been bound in an outer scope:

```scala
{
  val x = 2
  {
    println(x) // Forward reference to `x` declared in this  block. Does not compile
    val x = 3
    x + x
  }
}
```
