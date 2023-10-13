/*
 * The MIT License
 *
 * Copyright (c) 2023 Chirkunov Egor
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.justhm228.jlatenter.test;

import com.github.justhm228.jlatenter.latent.*;
import static com.github.justhm228.jlatenter.latent.Latent.*;
import static java.lang.System.*;
import java.util.*;
import java.util.concurrent.*;
import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;
import org.junit.*;
import static org.junit.Assert.*;

@AvailableSince(value = "0.1-build.1")
@NonExtendable()
@NonBlocking()
public final class LatentTest {

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@Contract(pure = true)
	public LatentTest() throws @NotNull(exception = NullPointerException.class) Error {

		super();
	}

	@Test()
	public void testA() throws @NotNull(exception = NullPointerException.class) Error {

		out.println("testA(): Before run() test");

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class RunTest {

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public RunTest() throws @NotNull(exception = NullPointerException.class) Error {

				super();
			}

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract()
			public int run() throws @NotNull(exception = NullPointerException.class) Error {

				out.println("run(): Hello World!");
				return 0;
			}
		}

		out.println("testA(): Before run()");
		as(new RunTest(), Runnable.class).run();
		out.println("testA(): After run()");
		out.println("testA(): After run() test");
	}

	@Test()
	public void testB() throws @NotNull(exception = NullPointerException.class) Error {

		out.println("testB(): Before static run() test");

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class StaticTest {

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public StaticTest() throws @NotNull(exception = NullPointerException.class) Error {

				super();
			}

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract()
			public static int run() throws @NotNull(exception = NullPointerException.class) Error {

				out.println("static run(): Hello World!");
				return 0;
			}
		}

		out.println("testB(): Before static run()");
		as(new StaticTest(), Runnable.class).run();
		out.println("testB(): After static run()");
		out.println("testB(): After static run() test");
	}

	@Test()
	public void testC() throws @NotNull(exception = NullPointerException.class) Error {

		out.println("testC(): Before failure test");

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class FailureTest {

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public FailureTest() throws @NotNull(exception = NullPointerException.class) Error {

				super();
			}

			public int call() throws @NotNull(exception = NullPointerException.class) Error {

				out.println("call(): Hello World!");
				return 0;
			}

			public void append(final CharSequence sequence) throws @NotNull(exception = NullPointerException.class) Error {

				fail("How did you get here ._.");
			}

			public Iterator<?> iterator() throws @NotNull(exception = NullPointerException.class) Error, @NotNull(exception = NullPointerException.class) UnsupportedOperationException {

				throw new UnsupportedOperationException("iterator() is unsupported!");
			}
		}

		final FailureTest test = new FailureTest();

		boolean thrown = false;

		out.println("testC(): 1 test started");

		try {

			as(null, null);

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			thrown = true;
			nullPointer.printStackTrace();
		}

		out.println("testC(): 1 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println("testC(): 2 test started");

		try {

			as(test, null);

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			thrown = true;
			nullPointer.printStackTrace();
		}

		out.println("testC(): 2 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println("testC(): 3 test started");

		try {

			as(null, Runnable.class);

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			thrown = true;
			nullPointer.printStackTrace();
		}

		out.println("testC(): 3 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println("testC(): 4 test started");

		try {

			as(test, Thread.class);

		} catch (@NotNull(exception = NullPointerException.class) final IllegalArgumentException notInterface) {

			thrown = true;
			notInterface.printStackTrace();
		}

		out.println("testC(): 4 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println("testC(): 5 test started");
		as(test, Runnable.class);
		out.println("testC(): 5 test ended");
		out.println("testC(): 6 test started");

		try {

			as(test, Runnable.class).run();

		} catch (@NotNull(exception = NullPointerException.class) final LatentNotPresentException notFound) {

			thrown = true;
			notFound.printStackTrace();
		}

		out.println("testC(): 6 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println("testC(): 7 test started");

		try {

			as(test, Appendable.class).append("Hello World!").append("How did you get here ._.");

		} catch (@NotNull(exception = NullPointerException.class) final IncompatibleLatentException incompatible) {

			thrown = true;
			incompatible.printStackTrace();

		} catch (@NotNull(exception = NullPointerException.class) final Exception impossible) {

			fail("How did you get here ._.");
			return;
		}

		out.println("testC(): 7 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println("testC(): 8 test started");

		// 8 test

		out.println("testC(): 8 test ended");
//		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println("testC(): 9 test started");

		// 9 test

		out.println("testC(): 9 test ended");
//		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println("testC(): 10 test started");

		try {

			as(test, Iterable.class).iterator();

		} catch (@NotNull(exception = NullPointerException.class) final LatentTargetException target) {

			thrown = true;
			target.printStackTrace();
		}

		out.println("testC(): 10 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;

		{

			final Object result;

			try {

				result = as(test, Callable.class).call();

			} catch (@NotNull(exception = NullPointerException.class) final Throwable anything) {

				anything.printStackTrace();
				fail("Failure test failed!");
				return;
			}

			assertEquals("How did you get here ._.", 0L, ((Integer) result).longValue());
		}

		out.println("testC(): After failure test");
	}

	@Test()
	public void testD() throws @NotNull(exception = NullPointerException.class) Error {

		out.println("testD(): Before \"isShadowed()-like\" test");

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class StaticTest {

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public StaticTest() throws @NotNull(exception = NullPointerException.class) Error {

				super();
			}

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract()
			public static int run() throws @NotNull(exception = NullPointerException.class) Error {

				out.println("run(): Hello World!");
				return 0;
			}
		}

		@NotNull(exception = NullPointerException.class)
		final StaticTest test = new StaticTest();

		out.println("testD(): Before \"isShadowed()-like\"");

		@NotNull(exception = NullPointerException.class)
		final Runnable shadow = as(test, Runnable.class);

		assertTrue("\"isShadowed()-like\" test failed!", isShadowed(shadow));
		assertSame("\"isShadowed()-like\" test failed!", test, find(shadow));
		assertSame("\"isShadowed()-like\" test failed!", test, find(shadow, StaticTest.class));

		try {

			final Void ignored = find(shadow, Void.class);

			fail("How did you get here ._.");
			return;

		} catch (@NotNull(exception = NullPointerException.class) final ClassCastException cast) {

			cast.printStackTrace();
		}

		assertFalse("\"isShadowed()-like\" test failed!", isShadowed(null));
		assertTrue("\"isShadowed()-like\" test failed!", isShadowed(shadow));

		try {

			final Object ignored = find(null);

			fail("How did you get here ._.");
			return;

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			nullPointer.printStackTrace();
		}

		try {

			final Void ignored = find(null, Void.class);

			fail("How did you get here ._.");

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			nullPointer.printStackTrace();

		} catch (@NotNull(exception = NullPointerException.class) final ClassCastException cast) {

			fail("How did you get here ._.");
			return;
		}

		assertNotNull("\"isShadowed()-like\" test failed!", find(shadow));

		try {

			assertNotNull("\"isShadowed()-like\" test failed!", find(shadow, Void.class));

		} catch (@NotNull(exception = NullPointerException.class) final ClassCastException cast) {

			fail("How did you get here ._.");
			return;
		}

		assertNotNull("\"isShadowed()-like\" test failed!", find(shadow));
		out.println("testD(): After \"isShadowed()-like\"");
		out.println("testD(): After \"isShadowed()-like\" test");
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws @NotNull(exception = NullPointerException.class) Error {

		return super.toString();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(@Nullable(value = "Can be null anytime") final Object another) throws @NotNull(exception = NullPointerException.class) Error {

		return another instanceof LatentTest;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws @NotNull(exception = NullPointerException.class) Error {

		return super.hashCode();
	}

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@Deprecated(since = "0.1-build.1")
	@Override()
	protected LatentTest clone() throws @NotNull(exception = NullPointerException.class) Error, @NotNull(exception = NullPointerException.class) CloneNotSupportedException {

		throw new CloneNotSupportedException(getClass().getTypeName());
	}

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Deprecated(since = "0.1-build.1", forRemoval = true)
	@Override()
	@SuppressWarnings(value = { "removal" })
	protected void finalize() throws @NotNull(exception = NullPointerException.class) Throwable {

		super.finalize();
	}
}
