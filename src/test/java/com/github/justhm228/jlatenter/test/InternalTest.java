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

import org.jetbrains.annotations.*;
import org.jetbrains.annotations.ApiStatus.*;
import org.junit.*;
import static com.github.justhm228.jlatenter.base.Library.*;
import static java.lang.System.*;
import static org.junit.Assert.*;
import static java.util.Objects.*;
import org.junit.rules.*;

/**
 * Tests the internal functions of the JLatenter library.
 *
 * <p>
 * <b>
 * Note: This test is considered the most "quiet" and/or "calm" because there were almost never any problems with the
 * internal API itself (the only problem that happened with it was precisely what led to the creation of this test).
 * Also, the internal API, at the time of writing the documentation, isn't particularly important. But despite this, the
 * existence of this test can't be ignored, and any change in the internal API should necessarily be accompanied by
 * changes to this test. And note that if one day this test fails, then you're very lucky.
 * </b>
 * </p>
 *
 * @author JustHuman228
 * @since 0.1-build.2
 */
@AvailableSince("0.1-build.2")
@NonExtendable()
@NonBlocking()
@FixMethodOrder()
@SuppressWarnings({ "suppress", "warningToken" })
public final class InternalTest {

	/**
	 * Stores a test name which is used in {@link System#out test output} and in
	 * <code>{@link #toString() toString}()</code> implementation.
	 *
	 * <p><b>Note: Currently, it's equal to the {@link Class#getSimpleName() simple name} of the
	 * {@link InternalTest current class}.</b></p>
	 *
	 * @since 0.1-build.4
	 */
	@AvailableSince("0.1-build.4")
	@Internal()
	@NotNull(exception = NullPointerException.class)
	private static final String TEST_NAME = InternalTest.class.getSimpleName(); // A string name of the current test

	@AvailableSince("0.1-build.4")
	@Internal()
	@NotNull(exception = NullPointerException.class)
	@Rule()
	public final TestName status = new TestName(); // Stores a name of the currently running method

	/**
	 * Instantiates a new instance of {@link InternalTest InternalTest}.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@NonBlocking()
	@Contract(pure = true)
	public InternalTest() throws Error {

		super(); // Just instantiate a new instance of `InternalTest` for JUnit 4 runner.
	}

	// ---------------------------------------- TEST START ----------------------------------------

	// Note: All the tests presented here will be invoked in declaration order because their names arranged according
	//       to the alphabet, and the JUnit 4 runner uses alphabetical sorting by default. You can sleep peacefully :)

	/**
	 * Tests whether the
	 * <code>{@link com.github.justhm228.jlatenter.base.Library Library}.{@link com.github.justhm228.jlatenter.base.Library#preventInstantiation() preventInstantiation}()</code>
	 * method will throw an {@link UnsupportedOperationException exception}.
	 *
	 * <p>
	 *     If the {@link UnsupportedOperationException exception} isn't thrown,
	 *     the test fails because this method should throw the
	 *     {@link UnsupportedOperationException exception} anyway.
	 * </p>
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws UnsupportedOperationException Should be thrown anyway. If it isn't, then the test failed.
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test(expected = UnsupportedOperationException.class) // <- This test MUST end up with this exception!
	public void testA() throws Error, UnsupportedOperationException {

		out.println(TEST_NAME + "." + status.getMethodName() + "(): Before preventInstantiation() call");
		preventInstantiation(); // <- This should always throw an exception if the internal API is OK

		// The code below should never be reached because of the exception thrown above:
		err.println(TEST_NAME + "." + status.getMethodName() +
				"(): After preventInstantiation() call: Already failed due to no exception has been thrown!");

		// Note: After the above statement reached, the test will automatically be failed because JUnit 4 runner won't
		//       receive the exception specified in the method descriptor!
	}

	/**
	 * Tests the message of the thrown by the
	 * <code>{@link com.github.justhm228.jlatenter.base.Library Library}.{@link com.github.justhm228.jlatenter.base.Library#preventInstantiation() preventInstantiation}()</code>
	 * method for matching a template.
	 *
	 * <p>
	 *     Calls the
	 *     <code>{@link com.github.justhm228.jlatenter.base.Library Library}.{@link com.github.justhm228.jlatenter.base.Library#preventInstantiation() preventInstantiation}()</code>
	 *     method, catches the {@link UnsupportedOperationException exception} it
	 *     throws (if none is thrown, the test automatically fails), and
	 *     compares its message with the expected one, which is equal to string
	 *     <code>{@link com.github.justhm228.jlatenter.base.Library Library}.{@link com.github.justhm228.jlatenter.base.Library#CONST_EMSG_UTILCLASS CONST_EMSG_UTILCLASS}</code>
	 *     formatted with the test class name as an argument. If it's equal, the test succeeds; otherwise,
	 *     the test fails and throws an {@link AssertionError AssertionError}. <b>This is needed to check
	 *     whether the method found the caller class correctly, because it's already found it incorrectly once.</b>
	 * </p>
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws AssertionError If the test failed.
	 */
	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test()
	public void testB() throws Error {

		out.println(TEST_NAME + "." + status.getMethodName() + "(): Before preventInstantiation() call");

		try {

			preventInstantiation(); // <- This should always throw an exception if the internal API is OK

		} catch (@NotNull(exception = NullPointerException.class) @SuppressWarnings("ignored") final
		UnsupportedOperationException init) { // <- This exception MUST be thrown if everything is OK!

			out.println(
					TEST_NAME + "." + status.getMethodName() +
							"(): After preventInstantiation() call (exception has been thrown and caught)");

			// Compare the actual exception message with the expected one to check if the caller search algorithm
			// is still working good:
			assertEquals(
					"Test failed due to the actual exception message isn't equal to the expected (possibly a caller search error)!",
					CONST_EMSG_UTILCLASS.formatted(getClass().getTypeName()), init.getMessage()
			            );

			return; // <- If this statement is reached, then the test is succeeded and we should finish it
		}

		// If the below statement is reached, then no exception has been thrown so the test should fail:
		fail("Test failed due to no exception has been thrown!");
	}

	/**
	 * Tests whether the
	 * <code>{@link com.github.justhm228.jlatenter.base.Library Library}.{@link com.github.justhm228.jlatenter.base.Library#preventClone() preventClone}()</code>
	 * method will throw an {@link CloneNotSupportedException exception}.
	 *
	 * <p>
	 *     If the {@link CloneNotSupportedException exception} isn't thrown,
	 *     the test fails because this method should throw the
	 *     {@link CloneNotSupportedException exception} anyway.
	 * </p>
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws CloneNotSupportedException Should be thrown anyway.
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test(expected = CloneNotSupportedException.class) // <- This test MUST end up with this exception!
	public void testC() throws Error, CloneNotSupportedException {

		out.println(TEST_NAME + "." + status.getMethodName() + "(): Before preventClone() call");
		preventClone(); // <- This should always throw an exception if the internal API is OK

		// The code below should never be reached because of the exception thrown above:
		err.println(
				TEST_NAME + "." + status.getMethodName() +
						"(): After preventClone() call: Already failed due to no exception has been thrown!");

		// Note: After the above statement reached, the test will automatically be failed because JUnit 4 runner won't
		//       receive the exception specified in the method descriptor!
	}

	/**
	 * Tests the message of the thrown by the
	 * <code>{@link com.github.justhm228.jlatenter.base.Library Library}.{@link com.github.justhm228.jlatenter.base.Library#preventClone() preventClone}()</code>
	 * method for matching a template.
	 *
	 * <p>
	 *     Calls the
	 *     <code>{@link com.github.justhm228.jlatenter.base.Library Library}.{@link com.github.justhm228.jlatenter.base.Library#preventClone() preventClone}()</code>
	 *     method, catches the {@link CloneNotSupportedException exception} it
	 *     throws (if none is thrown, the test automatically fails), and
	 *     compares its message with the expected one, which is equal to string
	 *     <code>{@link com.github.justhm228.jlatenter.base.Library Library}.{@link com.github.justhm228.jlatenter.base.Library#CONST_EMSG_IMMUTABLE CONST_EMSG_IMMUTABLE}</code>
	 *     formatted with the test class name as an argument. If it's equal, the test succeeds; otherwise,
	 *     the test fails and throws an {@link AssertionError AssertionError}. <b>This is needed to check
	 *     whether the method found the caller class correctly, because it's already found it incorrectly once.</b>
	 * </p>
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws AssertionError If the test failed.
	 */
	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test()
	public void testD() throws Error {

		out.println(TEST_NAME + "." + status.getMethodName() + "(): Before preventClone() call");

		try {

			preventClone(); // <- This should always throw an exception if the internal API is OK

		} catch (@NotNull(exception = NullPointerException.class) @SuppressWarnings("ignored") final
		CloneNotSupportedException unsupported) { // <- This exception MUST be thrown if everything is OK!

			out.println(TEST_NAME + "." + status.getMethodName() +
					"(): After preventClone() call (exception has been thrown and caught)");

			// Compare the actual exception message with the expected one to check if the caller search algorithm
			// is still working good:
			assertEquals(
					"Test failed due to the actual exception message isn't equal to the expected (possibly a caller search error)!",
					CONST_EMSG_IMMUTABLE.formatted(getClass().getTypeName()), unsupported.getMessage()
			            );

			return; // <- If this statement is reached, then the test is succeeded and we should finish it
		}

		// If the below statement is reached, then no exception has been thrown so the test should fail:
		fail("Test failed due to no exception has been thrown!");
	}

	// ---------------------------------------- TEST END ----------------------------------------

	/**
	 * Returns a string representation of {@link InternalTest this object}.
	 *
	 * <p>It just returns a current test name which is currently equal to the {@link Class#getSimpleName() simple name} of the {@link InternalTest object class}.</p>
	 *
	 * @return A string representation of {@link InternalTest this object}.
	 * @throws Error If something went wrong in the JVM.
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws Error {

		// Due to all `InternalTest` objects are "the same" and can't store any data, then we don't need to add here
		// some other information, so we can just return `TEST_NAME`:
		return TEST_NAME;
	}

	/**
	 * Indicates whether some {@link Object other object} is "equal to" {@link InternalTest this one}.
	 *
	 * <p>It just checks if the {@link Object passed object} is an instance of {@link InternalTest InternalTest}.</p>
	 *
	 * @param another A {@link Object reference object} with which to compare.
	 * @return If {@link InternalTest this object} is equal to the {@link Object argument}, then returns <code>true</code>, otherwise - <code>false</code>.
	 * @throws Error If something went wrong in the JVM.
	 */
	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(@Nullable(value = "Can be null anytime") final Object another) throws Error {

		// `InternalTest` can't store any data so if the passed object is an instance of `InternalTest` -
		// it's already equal to this object:
		return another instanceof InternalTest;
	}

	/**
	 * Returns a hash code value for {@link InternalTest this object}.
	 *
	 * <p>It just returns the {@link java.util.Objects#hash(Object...) hash} of the {@link InternalTest object class}.</p>
	 *
	 * @return A hash code value for {@link InternalTest this object}.
	 * @throws Error If something went wrong in the JVM.
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws Error {

		// Due to all `InternalTest` objects are "the same" and can't sore any data, then we don't need to calculate
		// a unique hash code for every object, so we can just return the hash of the object class:
		return hash(getClass());
	}

	/**
	 * Prevents cloning.
	 *
	 * <p>Yeah, it just throws an {@link CloneNotSupportedException exception}.</p>
	 *
	 * @return Never returns.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws CloneNotSupportedException Always.
	 * @since 0.1-build.2
	 */
	@AvailableSince("0.1-build.2")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@Override()
	@SuppressWarnings({ "super", "CloneDoesntCallSuperClone" })
	protected InternalTest clone() throws Error, CloneNotSupportedException {

		// Always prevent cloning (even if `InternalTest` will implement `Cloneable`) -
		// no instances should be instantiated!
		return preventClone();
	}
}
