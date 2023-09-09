# JLatenter

---

**JLatenter** is a small implementation of latent typing in Java which uses dynamic proxies to redirect method calls from an interface stub to the real object.
**I don't know how original this thing is**, I just came up with this implementation of this idea and decided to do it because why not.

## How to Use

---

There's a little background here. I studied the Java programming language for almost 2 years, mostly using the Internet.
In addition to just studying the theory, I simultaneously wrote my programs, encountered problems and found answers to them on StackOverflow or, in the end, in various English-language articles.
Over the course of my time, I have visited many sites, many of which you may not have even heard of.
But besides this, I also read books.
One of them was Bruce Eckel's book "Thinking in Java", 4th Edition (an excellent book, by the way, I recommend reading it - it will be at least interesting).
I first saw the idea of implementing latent typing in Java there.
But I wasn't interested in implementing it - I thought it was a useless exercise.
Later, when I had already studied Java to a level acceptable to me personally, I began to write various software for myself, which I might later post on GitHub, and, in fact, I started GitHub itself - at a minimum, it definitely won't be superfluous.
But then, I simply ran out of ideas, and my study began (just in time...).
And then, during a regular walk, the idea of combining dynamic proxies and latent typing from Python came to my mind.
This is how this implementation was born.
I wanted to make it as user-friendly and take up the least amount of code space as possible.
So small that the function call can look like this:

```python
def main(task):  # <-- Parameter `task` should be a function
	task()  # Call the passed function

def run():
	print('Hello World!')


if __name__ == '__main__':
	main(run)  # Pass function as an argument
```

or like this:

```
def main(obj):
	obj.run()
	
if __name__ == '__main__':
	pass  # Sorry but I'm too lazy to complete this example - I just have no time (maybe later)
```

But in the end, it looks like this:

```java
import com.github.justhm228.jlatenter.latent.*;
import static com.github.justhm228.jlatenter.latent.Latent.*;

public class Main {

	public static void main(String[] args) throws LatentException { // <-- If something went wrong
		
		final Object instance = new Task();

		as(instance, Runnable.class).run(); // <-- Interpreting `instance` as a `Runnable`
	}
}

class Task { // <-- It doesn't implement `Runnable`
	
	void run() {
		
		System.out.println("Hello World!");
	}
}
```

This, of course, isn't particularly similar to Python, but at least it's very short and clear, right?
And it's as simple as Python itself, because...
There is nothing complicated here, because... the only class you will have to work with is `Latent`.
The class contains 3 overloaded methods:

- `as()`
- `isShadowed()`
- `find()`.

`as()` takes as the first argument the object whose method you want to call, and the second argument in the two overloaded versions is different:

- In the first version it's a reference to the interface as which you want to represent the object
- In the second version it's an object that implements a single interface, as which an object can be represented (it's a failed experiment, please forget about its existence).

The `isShadowed()` method accepts a single object and returns `true` if the object is the "shadow" of another object, and `false` if not.
The `find()` method takes as a required parameter a "shadow" object, and as an optional parameter the class to which you want to cast the return value using generics.
The method itself simply returns a reference to an object whose "shadow" is the argument passed to it.
Methods of the "shadow" object don't throw exceptions, except for subclasses of `LatentException`, so all checked exceptions can be suppressed in the `catch` block.
A `LatentException` is thrown if the called method isn't found, its return value is incompatible with the original, the method is inaccessible, an exception has occurred in the initializer, or the method threw an exception.
Everything is like in the Reflection API.
Also, some built-in stub interfaces have been prepared for you that you can use instead of creating a new class with your method (there will be more of them in the future):

- `Startable` - contains a `start()` method which accepts no parameters and returns `void`
- `Stoppable` - contains a `stop()` method which accepts no parameters and returns `void`
- `Pausable` - contains a `pause()` method which accepts no parameters and returns `void`
- `Formattable` - a parent for all format/print stubs
- - `SelfPrintable` - contains a `print()` method which accepts no parameters and returns `void`
- - `XPrintable` - contains a `print()` method which accepts `Object` as a parameter and returns `void`
- - `SelfPrintableLN` - contains a `println()` method which accepts no parameters and returns `void`
- - `XPrintableLN` - contains a `println()` method which accepts `Object` as a parameter and returns `void`
- - `SelfFormattable` - contains a `format()` method which accepts `Object...` as a parameter and returns `void`
- - `SelfFormatted` - contains a `formatted()` method which accepts `Object...` as a parameter and returns `String`
- - `SelfPrintableF` - contains a `printf()` method which accepts `Object...` as a parameter and returns `void`
- - `XFormattable` - contains a `format()` method which accepts `Object` and `Object...` as parameters and returns `void`
- - `XPrintableF` - contains a `printf()` method which accepts `Object` and `Object...` as paramaters and returns `void`
- `@Shadow` - just an annotation which marks all interface stubs *(it's optional)*
- `Buildable` - a parent for all build stubs
- - `XBuildable` - contains a `build()` method which accepts no parameters and returns `void`
- - `SelfBuildable` - contains a `build()` method which accepts no parameters and returns `Object` (`this` reference)
- - `GenericBuildable` - contains a `build()` method which accepts no parameters and returns generic `T` (`this` reference)
- - `SelfBuildableC` - contains a `build()` method which accepts no parameters and returns `Object` (another object, not `this`)
- - `GenericBuildableC` - contains a `build()` method which accepts no parameters and returns generic `T` (another object, not `this`)
- `Renderable` - contains a `render()` method which accepts no parameters and returns `void`
- `Drawable` - contains a `draw()` method which accepts no parameters and returns `void`
- `Paintable` - contains a `paint()` method which accepts no parameters and returns `void`
- `Steppable` - contains a `step()` method which accepts no parameters and returns `void`
- `Gettable` - contains a `get()` method which accepts no parameters and returns `Object`
- `Puttable` - contains a `put()` method which accepts no parameters and returns `void`

And, you won't believe it, but that's all.
Yes, I tried to simplify everything so much.
Also, if you take into account that you can use static import to call the `as()` method (like in the examples), it turns out that you can call the function you need in almost one line (possibly even without creating a new interface).
**The only thing remaining is that the garbage collector won't be able to destroy the original object while its "shadow" exists, because it references original directly, so take that into account (I won't fix this).**
I hope I explained clearly.

## Examples

---

I'd write more examples, but... I don't have enough time for this, so for now let there be only 1 example:

```java
import com.github.justhm228.jlatenter.latent.LatentException;
import com.github.justhm228.jlatenter.latent.Startable;
import com.github.justhm228.jlatenter.latent.Stoppable;
import static com.github.justhm228.jlatenter.latent.Latent.as;

public class Example {

	public static void start(Object process) throws LatentException {

		as(process, Startable.class).start();
		// Do something...
	}
	
	public static void stop(Object process) throws LatentException {
		
		as(process, Stoppable.class).stop();
		// Do something...
	}
	
	// I'm too lazy to create more informative examples, sorry :(
}
```

Just wait until I got the time, okay?

## Future Plans

---

I really wanted to finish at 0.1-build.1 initially, but then I realized that I could turn this spontaneous idea into something more and add a little more functionality.
But first, I need to add more stub interfaces.
So much more that a potential user won't have to write his own - it will be enough to look through the list of built-ins.
This is a very simple task in terms of implementation and time, but however, I alone don't have enough imagination, so any ideas are welcome.
Also, I think I will need to improve the implementation, optimize it, add better parameter checking (take into account varargs, wrappers, etc.) and possibly get rid of the `IncompatibleLatentException` caused by absence of default `null` values.
And finally...
I want to add some meaning to `@Shadow`'s annotation, because right now it's just decoration.
If anything, I'm not talking about rewriting the code so that it only accepts stubs with this annotation.
Still, it isn't for nothing that I decided to use dynamic proxies to solve the problem of call redirection.
I can add some additional, optional parameters to the annotation, which, for example, will redirect a call to the manually-specified method, change the search algorithm, or even control the built-in profiler (yes, I know, it's corny, but why not).
The possibilities in this regard are endless!
That's why I decided not to complete this idea that spontaneously came to me with 0.1-build.1 - I want to determine how I can "play" with this implementation, how to expand it, what I can basically do with it.
So I promise that I will at least try to do something similar.

- [x] Come up with an idea.
- [x] Implement the idea.
- [ ] Add more stub interfaces.
- [ ] Improve/optimize the current implementation.
- - [ ] Refactor the code.
- - [ ] Migrate from Reflection API to Method Handles API.
- [ ] Improve parameter checking system (for better redirecting).
- - [ ] Take into account varargs (to allow such redirections: `example() -> example(Object...) // <-- 0 elements`).
- - [ ] Take into account wrapper types (to allow such redirections: `example(int) -> example(Integer) // <-- if there's no other methods` or `example(Integer) -> example(int)`).
- - [ ] And etc.
- [ ] Possibly get rid of `IncompatibleLatentException` caused by `void` (just return `null`-like values in cases of conflict - it will be hard)
- [ ] Do something with `@Shadow`
- [ ] Abandon the project?..

Well, something like this.
