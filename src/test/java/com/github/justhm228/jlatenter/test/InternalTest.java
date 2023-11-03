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
@SuppressWarnings({ "suppress", "warningToken" })
public final class InternalTest {

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

		super();
	}

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
	@Test(expected = UnsupportedOperationException.class)
	public void testA() throws Error, UnsupportedOperationException {

		out.println("InternalTest.testA(): Before preventInstantiation() call");
		preventInstantiation();
		err.println(
				"InternalTest.testA(): After preventInstantiation() call: Already failed due to no exception has been thrown!");
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

		out.println("InternalTest.testB(): Before preventInstantiation() call");

		try {

			preventInstantiation();

		} catch (@NotNull(exception = NullPointerException.class) @SuppressWarnings("ignored") final
		UnsupportedOperationException init) {

			out.println(
					"InternalTest.testB(): After preventInstantiation() call (exception has been thrown and caught)");
			assertEquals(
					"Test failed due to the actual exception message isn't equal to the expected (possibly a caller search error)!",
					CONST_EMSG_UTILCLASS.formatted(getClass().getTypeName()), init.getMessage()
			            );
			return;
		}

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
	@AvailableSince(value = "0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test(expected = CloneNotSupportedException.class)
	public void testC() throws Error, CloneNotSupportedException {

		out.println("InternalTest.testC(): Before preventClone() call");
		preventClone();
		err.println(
				"InternalTest.testC(): After preventClone() call: Already failed due to no exception has been thrown!");
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
	@AvailableSince(value = "0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract()
	@Test()
	public void testD() throws Error {

		out.println("InternalTest.testD(): Before preventClone() call");

		try {

			preventClone();

		} catch (@NotNull(exception = NullPointerException.class) @SuppressWarnings("ignored") final
		CloneNotSupportedException unsupported) {

			out.println("InternalTest.testD(): After preventClone() call (exception has been thrown and caught)");
			assertEquals(
					"Test failed due to the actual exception message isn't equal to the expected (possibly a caller search error)!",
					CONST_EMSG_IMMUTABLE.formatted(getClass().getTypeName()), unsupported.getMessage()
			            );
			return;
		}

		fail("Test failed due to no exception has been thrown!");
	}

	/**
	 * Returns a string representation of {@link InternalTest this object}.
	 *
	 * <p>It just returns a {@link Class#getSimpleName() simple name} of the {@link InternalTest object class}.</p>
	 *
	 * @return A string representation of {@link InternalTest this object}.
	 * @throws Error If something went wrong in the JVM.
	 * @since 0.1-build.2
	 */
	@AvailableSince(value = "0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws Error {

		return getClass().getSimpleName();
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
	@AvailableSince(value = "0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(@Nullable(value = "Can be null anytime") final Object another) throws Error {

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
	@AvailableSince(value = "0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws Error {

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
	@AvailableSince(value = "0.1-build.2")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@Override()
	@SuppressWarnings({ "super", "CloneDoesntCallSuperClone" })
	protected InternalTest clone() throws Error, CloneNotSupportedException {

		return preventClone();
	}
}
