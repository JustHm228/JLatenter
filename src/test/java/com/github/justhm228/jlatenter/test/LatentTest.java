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

@AvailableSince("0.1-build.1")
@NonExtendable()
@SuppressWarnings({ "suppress", "warningToken" })
public final class LatentTest {

	@AvailableSince("0.1-build.1")
	@Internal()
	@NotNull(exception = NullPointerException.class)
	private static final String TEST_NAME = LatentTest.class.getSimpleName();

	@AvailableSince("0.1-build.1")
	@NonBlocking()
	@Contract(pure = true)
	public LatentTest() throws Error {

		super();
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test()
	public void testA() throws Error {

		@AvailableSince("0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class RunTest {

			@AvailableSince("0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public RunTest() throws Error {

				super();
			}

			@AvailableSince("0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract(" -> _")
			@SuppressWarnings("unused")
			public int run() throws Error {

				out.println(TEST_NAME + ".$.run(): Hello World!");
				return 0;
			}
		}

		out.println(TEST_NAME + ".testA(): Before non-static run() call");
		as(new RunTest(), Runnable.class).run();
		out.println(TEST_NAME + ".testA(): After non-static run() call");
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test()
	@SuppressWarnings("InstantiationOfUtilityClass")
	public void testB() throws Error {

		@AvailableSince("0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class StaticTest {

			@AvailableSince("0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public StaticTest() throws Error {

				super();
			}

			@AvailableSince("0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract(" -> _")
			@SuppressWarnings("unused")
			public static int run() throws Error {

				out.println(TEST_NAME + ".$.static run(): Hello World!");
				return 0;
			}
		}

		out.println(TEST_NAME + ".testB(): Before static run() call");
		as(new StaticTest(), Runnable.class).run();
		out.println(TEST_NAME + ".testB(): After static run() call");
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@Blocking()
	@Contract()
	@Test()
	@SuppressWarnings({ "CallToPrintStackTrace", "UnusedAssignment", "noEffectAssign" })
	public void testC() throws Error {

		out.println(TEST_NAME + ".testC(): Before failure test");

		@AvailableSince("0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class FailureTest {

			@AvailableSince("0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public FailureTest() throws Error {

				super();
			}

			@AvailableSince("0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract(" -> _")
			@SuppressWarnings("unused")
			public int call() throws Error {

				out.println(TEST_NAME + ".$.call(): Hello World!");
				return 0;
			}

			@AvailableSince("0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract(value = "_ -> fail", pure = true)
			@SuppressWarnings("unused")
			public void append(
					@Nullable("Can be null anytime") @SuppressWarnings("ignored") final CharSequence sequence
			                  ) throws Error {

				fail("How did you get here ._.");
			}

			@AvailableSince("0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract(value = " -> fail", pure = true)
			@SuppressWarnings("unused")
			public Iterator<?> iterator() throws Error, UnsupportedOperationException {

				throw new UnsupportedOperationException("iterator() is unsupported!");
			}
		}

		@NotNull(exception = NullPointerException.class)
		final FailureTest test = new FailureTest();

		boolean thrown = false;

		out.println(TEST_NAME + ".testC(): Checking failure #1...");

		try {

			@SuppressWarnings("ignored")
			final Object ignored = as(null, null);

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			thrown = true;
			nullPointer.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): Failure #1 has been checked!");
		assertTrue("Failure #1 hasn't been occurred!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): Checking failure #2...");

		try {

			@SuppressWarnings("ignored")
			final Object ignored = as(test, null);

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			thrown = true;
			nullPointer.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): Failure #2 has been checked!");
		assertTrue("Failure #2 hasn't been occurred!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): Checking failure #2...");

		try {

			@SuppressWarnings("ignored")
			final Object ignored = as(null, Runnable.class);

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			thrown = true;
			nullPointer.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): Failure #3 has been checked!");
		assertTrue("Failure #3 hasn't been occurred!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): Checking failure #4...");

		try {

			@SuppressWarnings("ignored")
			final Object ignored = as(test, Thread.class);

		} catch (@NotNull(exception = NullPointerException.class) final IllegalArgumentException notInterface) {

			thrown = true;
			notInterface.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): Failure #4 has been checked!");
		assertTrue("Failure #4 hasn't been occurred!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): Checking \"failure\" #5...");

		{

			@NotNull(exception = NullPointerException.class)
			@SuppressWarnings("ignored")
			final Object ignored = as(test, Runnable.class);
		}

		out.println(TEST_NAME + ".testC(): \"Failure\" #5 has been checked: No exception has occurred!");
		out.println(TEST_NAME + ".testC(): Checking failure #6...");

		try {

			as(test, Runnable.class).run();

		} catch (@NotNull(exception = NullPointerException.class) final LatentNotPresentException notFound) {

			thrown = true;
			notFound.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): Failure #6 has been checked!");
		assertTrue("Failure #6 hasn't been occurred!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): Checking failure #7...");

		try {

			as(test, Appendable.class).append("Hello World!").append("How did you get here ._.");

		} catch (@NotNull(exception = NullPointerException.class) final IncompatibleLatentException incompatible) {

			thrown = true;
			incompatible.printStackTrace();

		} catch (@NotNull(exception = NullPointerException.class) @SuppressWarnings("ignored") final
		Exception impossible) {

			fail("How did you get here ._.");
			return;
		}

		out.println(TEST_NAME + ".testC(): Failure #7 has been checked!");
		assertTrue("Failure #7 hasn't been occurred!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): Checking failure #8...");

		// TODO: 29.10.2023 Insert here a code of failure #8 later...

		out.println(TEST_NAME + ".testC(): Failure #8 has been checked!");
		// assertTrue("Failure #8 hasn't been occurred!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): Checking failure #9...");

		// TODO: 29.10.2023 Insert here a code of failure #9 later...

		out.println(TEST_NAME + ".testC(): Failure #9 has been checked!");
		// assertTrue("Failure #9 hasn't been occurred!", thrown);
		thrown = false;
		out.println(TEST_NAME + ".testC(): Checking failure #10...");

		try {

			as(test, Iterable.class).iterator();

		} catch (@NotNull(exception = NullPointerException.class) final LatentTargetException target) {

			thrown = true;
			target.printStackTrace();
		}

		out.println(TEST_NAME + ".testC(): Failure #10 has been checked!");
		assertTrue("Failure #10 hasn't been occurred!", thrown);
		out.println(TEST_NAME + ".testC(): Checking \"failure\" #11...");

		{

			final Object result;

			try {

				result = as(test, Callable.class).call();

			} catch (@NotNull(exception = NullPointerException.class) final Throwable anything) {

				anything.printStackTrace();
				fail("\"Failure\" #11 has been checked: An exception has occurred!");
				return;
			}

			assertNotNull("How did you get here ._.", result);
			assertEquals("How did you get here ._.", 0L, ((Integer) result).longValue());
			out.println(TEST_NAME + ".testC(): \"Failure\" #11 has been checked: No exception has occurred!");
		}

		out.println(TEST_NAME + ".testC(): After failure test");
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test()
	@SuppressWarnings({ "deprecation", "CallToPrintStackTrace" })
	public void testD() throws Error {

		@AvailableSince("0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		final class StaticTest {

			@AvailableSince("0.1-build.1")
			@Internal()
			@NonBlocking()
			@Contract(pure = true)
			public StaticTest() throws Error {

				super();
			}

			@AvailableSince("0.1-build.1")
			@Internal()
			@NonExtendable()
			@NonBlocking()
			@Contract(" -> _")
			@SuppressWarnings("unused")
			public static int run() throws Error {

				out.println(TEST_NAME + ".$.run(): Hello World!");
				return 0;
			}
		}

		@NotNull(exception = NullPointerException.class)
		@SuppressWarnings("InstantiationOfUtilityClass")
		final StaticTest test = new StaticTest();

		out.println(TEST_NAME + ".testD(): Before \"isShadowed()-like\" calls");

		@NotNull(exception = NullPointerException.class)
		final Runnable shadow = as(test, Runnable.class);

		assertTrue("\"isShadowed()-like\" test failed!", isShadowed(shadow));
		assertSame("\"isShadowed()-like\" test failed!", test, find(shadow));
		assertSame("\"isShadowed()-like\" test failed!", test, find(shadow, StaticTest.class));

		try {

			@SuppressWarnings("ignored")
			final Void ignored = find(shadow, Void.class);

			fail("How did you get here ._.");
			return;

		} catch (@NotNull(exception = NullPointerException.class) final ClassCastException cast) {

			cast.printStackTrace();
		}

		assertFalse("\"isShadowed()-like\" test failed!", isShadowed(null));
		assertTrue("\"isShadowed()-like\" test failed!", isShadowed(shadow));

		try {

			@SuppressWarnings("ignored")
			final Object ignored = find(null);

			fail("How did you get here ._.");
			return;

		} catch (@NotNull(exception = NullPointerException.class) final NullPointerException nullPointer) {

			nullPointer.printStackTrace();
		}

		try {

			@SuppressWarnings("ignored")
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
		out.println(TEST_NAME + ".testD(): After \"isShadowed()-like\" calls");
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws Error {

		return super.toString();
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(@Nullable("Can be null anytime") final Object another) throws Error {

		return another instanceof LatentTest;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws Error {

		return super.hashCode();
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@Override()
	@SuppressWarnings({ "super", "CloneDoesntCallSuperClone" })
	protected LatentTest clone() throws Error, CloneNotSupportedException {

		// throw new CloneNotSupportedException(getClass().getTypeName());

		return preventClone();
	}

	@AvailableSince("0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Deprecated(since = "0.1-build.1", forRemoval = true)
	@Override()
	@SuppressWarnings("removal")
	protected void finalize() throws Throwable {

		super.finalize();
	}
}
