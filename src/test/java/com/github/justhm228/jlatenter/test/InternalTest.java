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

@AvailableSince("0.1-build.2")
@NonExtendable()
@NonBlocking()
@SuppressWarnings({ "suppress", "warningToken" })
public final class InternalTest {

	@AvailableSince("0.1-build.2")
	@NonBlocking()
	@Contract(pure = true)
	public InternalTest() throws Error {

		super();
	}

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

	@AvailableSince(value = "0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws Error {

		return super.toString();
	}

	@AvailableSince(value = "0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(@Nullable(value = "Can be null anytime") final Object another) throws Error {

		return another instanceof InternalTest;
	}

	@AvailableSince(value = "0.1-build.2")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws Error {

		return super.hashCode();
	}

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
