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
import static com.github.justhm228.jlatenter.base.Library.*;
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
public final class LatentTest {

	private static final String TEST_NAME = LatentTest.class.getSimpleName();

	@AvailableSince(value = "0.1-build.1")
	@NonBlocking()
	@Contract(pure = true)
	public LatentTest() throws Error {

		super();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test()
	public void testA() throws Error {

		out.println(TEST_NAME + ".testA(): Before run() test");

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class RunTest {

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public RunTest() throws Error {

				super();
			}

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract()
			public int run() throws Error {

				out.println(TEST_NAME + ".$.run(): Hello World!");
				return 0;
			}
		}

		out.println(TEST_NAME + ".testA(): Before run()");
		as(new RunTest(), Runnable.class).run();
		out.println(TEST_NAME + ".testA(): After run()");
		out.println(TEST_NAME + ".testA(): After run() test");
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test()
	public void testB() throws Error {

		out.println(TEST_NAME + ".testB(): Before static run() test");

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class StaticTest {

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public StaticTest() throws Error {

				super();
			}

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract()
			public static int run() throws Error {

				out.println(TEST_NAME + ".$.static run(): Hello World!");
				return 0;
			}
		}

		out.println(TEST_NAME + ".testB(): Before static run()");
		as(new StaticTest(), Runnable.class).run();
		out.println(TEST_NAME + ".testB(): After static run()");
		out.println(TEST_NAME + ".testB(): After static run() test");
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@Blocking()
	@Contract()
	@Test()
	public void testC() throws Error {

		out.println(TEST_NAME + ".testC(): Before failure test");

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class FailureTest {

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public FailureTest() throws Error {

				super();
			}

			public int call() throws Error {

				out.println(TEST_NAME + ".$.call(): Hello World!");
				return 0;
			}

			public void append(final CharSequence sequence) throws Error {

				fail("How did you get here ._.");
			}

			public Iterator<?> iterator() throws Error, UnsupportedOperationException {

				throw new UnsupportedOperationException("iterator() is unsupported!");
			}
		}

		final FailureTest test = new FailureTest();

		boolean thrown = false;

		out.println(TEST_NAME + ".testC(): 1 test started");

		try {

			as(null, null);

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			thrown = true;
			nullPointer.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): 1 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): 2 test started");

		try {

			as(test, null);

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			thrown = true;
			nullPointer.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): 2 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): 3 test started");

		try {

			as(null, Runnable.class);

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			thrown = true;
			nullPointer.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): 3 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): 4 test started");

		try {

			as(test, Thread.class);

		} catch (@NotNull(exception = NullPointerException.class) final IllegalArgumentException notInterface) {

			thrown = true;
			notInterface.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): 4 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): 5 test started");
		as(test, Runnable.class);
		out.println(TEST_NAME + ".testC(): 5 test ended");
		out.println(TEST_NAME + ".testC(): 6 test started");

		try {

			as(test, Runnable.class).run();

		} catch (@NotNull(exception = NullPointerException.class) final LatentNotPresentException notFound) {

			thrown = true;
			notFound.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): 6 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): 7 test started");

		try {

			as(test, Appendable.class).append("Hello World!").append("How did you get here ._.");

		} catch (@NotNull(exception = NullPointerException.class) final IncompatibleLatentException incompatible) {

			thrown = true;
			incompatible.printStackTrace();

		} catch (@NotNull(exception = NullPointerException.class) final Exception impossible) {

			fail("How did you get here ._.");
			return;
		}

		out.println(TEST_NAME + ".testC(): 7 test ended");
		assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): 8 test started");

		// 8 test

		out.println(TEST_NAME + ".testC(): 8 test ended");
		// assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): 9 test started");

		// 9 test

		out.println(TEST_NAME + ".testC(): 9 test ended");
		// assertTrue("Failure test failed!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): 10 test started");

		try {

			as(test, Iterable.class).iterator();

		} catch (@NotNull(exception = NullPointerException.class) final LatentTargetException target) {

			thrown = true;
			target.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): 10 test ended");
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

		out.println(TEST_NAME + ".testC(): After failure test");
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test()
	@SuppressWarnings(value = { "deprecation" })
	public void testD() throws Error {

		out.println(TEST_NAME + ".testD(): Before \"isShadowed()-like\" test");

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class StaticTest {

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public StaticTest() throws Error {

				super();
			}

			@AvailableSince(value = "0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract()
			public static int run() throws Error {

				out.println(TEST_NAME + ".$.run(): Hello World!");
				return 0;
			}
		}

		@NotNull(exception = NullPointerException.class)
		final StaticTest test = new StaticTest();

		out.println(TEST_NAME + ".testD(): Before \"isShadowed()-like\"");

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
		out.println(TEST_NAME + ".testD(): After \"isShadowed()-like\"");
		out.println(TEST_NAME + ".testD(): After \"isShadowed()-like\" test");
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws Error {

		return super.toString();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(@Nullable(value = "Can be null anytime") final Object another) throws Error {

		return another instanceof LatentTest;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws Error {

		return super.hashCode();
	}

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@Override()
	protected LatentTest clone() throws Error, CloneNotSupportedException {

		// throw new CloneNotSupportedException(getClass().getTypeName());

		return preventClone();
	}

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Deprecated(since = "0.1-build.1", forRemoval = true)
	@Override()
	@SuppressWarnings(value = { "removal" })
	protected void finalize() throws Throwable {

		super.finalize();
	}
}
