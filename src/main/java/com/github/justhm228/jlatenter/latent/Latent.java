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

package com.github.justhm228.jlatenter.latent;

import static com.github.justhm228.jlatenter.base.Library.*;
import static java.lang.System.*;
import java.lang.reflect.*;
import static java.lang.reflect.Proxy.*;
import java.security.*;
import java.util.*;
import static java.util.Objects.toIdentityString;
import static java.util.Objects.hash;
import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;

@AvailableSince("0.1-build.1")
@NonExtendable()
@NonBlocking()
@SuppressWarnings({ "suppress", "warningToken" })
public final class Latent {

	@AvailableSince("0.1-build.1")
	@Internal()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@SuppressWarnings("unused")
	private Latent() throws Error, UnsupportedOperationException {

		super();

		// throw new UnsupportedOperationException(
		//
		// 		"An instance of this type (" +
		// 				getClass().getTypeName() +
		// 		") can't be instantiated with a constructor!"
		// );

		preventInstantiation();
	}

	/**
	 * "Interprets" the specified object as an interface implemented by the passed "stub" object.
	 *
	 * <p>
	 * Yes, it's really a little hard to understand the first time, so if you don't understand, then look at this
	 * example:
	 * </p>
	 *
	 * <pre>
	 *     {@code
	 *         Object shadowed = ... // <- Place any object which contains a valid `run()` method here
	 *
	 *         class TestStub implements Runnable { // <- Just a "stub" class
	 *
	 *             @Override
	 *             public void run() {
	 *
	 *                 // Do nothing...
	 *             }
	 *         }
	 *
	 *         Runnable stub = new TestStub(); // Losing the type of a "stub" object to make it more useful
	 *
	 *         Runnable shadow = ((Runnable) as(shadowed, stub)); // Interpret `shadowed` as the interface implemented by `stub`
	 *
	 *         shadow.run(); // Do something with `shadow`...
	 *     }
	 * </pre>
	 * <p>
	 * In this example, the <code>TestStub</code> class is created and implemented
	 * <code>{@link Runnable Runnable}</code>. It's needed only to be able to instantiate
	 * an object that can be cast to `Runnable`, which will be a "stub" object. The <code>shadowed</code> object and a
	 * "stub" object are then passed to the <code>{@link #as(Object, Object)}()</code> method, which in turn
	 * "interprets"
	 * <code>shadowed</code> as a <code>{@link Runnable Runnable}</code>, allowing the program
	 * to further interact with the resulting object as with a <code>{@link Runnable Runnable}</code>. At the design
	 * stage, this method looked very simple and useful, but in practice it turned out to be useless and very hard to
	 * understand, which led to its deprecation.
	 *
	 * <p>Use {@link #as(Object, Class) this implementation} of <code>as()</code> instead.</p>
	 *
	 * @param instance An object to be "shadowed".
	 * @param type A "stub" object of class which implements an interface as which the specified object should be
	 * "interpreted".
	 *
	 * @return A "shadow" of the specified object.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws NullPointerException If any argument specified is <code>null</code>.
	 * @throws IllegalArgumentException If the number of interfaces implemented by the passed "stub" object is more or
	 * less than 1.
	 * @see #as(Object, Class)
	 * @since 0.1-build.1
	 * @deprecated This method has been created to solve situations in which there's an instance of an interface in the
	 * form of which the specified object should be "interpreted". The convenience of its use had to be guaranteed by
	 * use of generic types. But, in practice, it turned out that generic types only got in the way, which is why they
	 * had to be removed, which made this method even more inconvenient than if the user had solved this "problem" on
	 * their own. <b>Or, in short, this method is marked as deprecated because it's useless and hard to understand.</b>
	 * Of course, you can still use it safely for now, but this isn't recommended.
	 * <b>Please, forget about its existence.</b>
	 */
	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	// <- Deprecated because it's useless and hard to understand. Please, forget about it.
	@SuppressWarnings({ "unused", "javadoc" })
	public static @NotNull(exception = NullPointerException.class) Object as(
			@NotNull(value = "The specified latent instance is null!") final Object instance,
			@NotNull(
					value = "The specified cast type is null!", exception = NullPointerException.class
			) final Object type
	                                                                        )
			throws Error, NullPointerException, IllegalArgumentException {

		// requireNonNull(instance, "The specified latent instance is null!");
		// requireNonNull(type, "The specified cast type is null!");

		checkForNull("The specified latent instance", instance);
		checkForNull("The specified cast type", type);

		@NotNull(exception = NullPointerException.class)
		final Class<?> @NotNull(exception = NullPointerException.class) [] latents =
				type.getClass().getInterfaces();

		final int length = latents.length;

		if (length != 1) {

			throw new IllegalArgumentException(

					"The number of latents (" +
					length +
					") in the specified cast type (" +
					type +
					") isn't equal 1!"
			);
		}

		return as(instance, latents[0]);
	}

	/**
	 * "Interprets" the specified {@link Object object} as the specified {@link Class type}.
	 *
	 * <p>See the {@link Latent class documentation} for details.</p>
	 *
	 * @param instance An {@link Object object} to be "interpreted" as the specified {@link Class type}.
	 * @param type A {@link Class type} as which the specified {@link Object object} will be "interpreted".
	 * @param <T> The specified {@link Class type} as a generic.
	 *
	 * @return A "shadow" of the specified {@link Object object}.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws NullPointerException If any specified parameter is <code>null</code>.
	 * @throws IllegalArgumentException If the specified {@link Class type} isn't an <code>interface</code>.
	 * @throws SecurityException If the global <code>AccessControlContext</code> isn't initialized and the caller
	 * doesn't have permission <code>{@link SecurityPermission SecurityPermission}("createAccessControlContext")</code>
	 * to initialize it and doesn't have such permissions:
	 * <ul>
	 *     <li>
	 *         <code>{@link RuntimePermission RuntimePermission}("getClassLoader")</code> -
	 *         if the specified {@link Class type} is loaded by
	 *         the bootstrap {@link ClassLoader classloader} and
	 *         the caller's {@link ClassLoader classloader} isn't
	 *         the {@link ClassLoader same}
	 *     </li>
	 *     <li>
	 *         <code>{@link RuntimePermission RuntimePermission}("accessClassInPackage." + type.getPackageName())</code> -
	 *         if the specified {@link Class type}'s {@link ClassLoader classloader} isn't
	 *         the {@link ClassLoader same} as or an {@link ClassLoader ancestor} of
	 *         the caller's {@link ClassLoader classloader}
	 *     </li>
	 *     <li>
	 *         <code>{@link RuntimePermission RuntimePermission}("newProxyInPackage." + proxyPkg)</code> -
	 *         if the specified {@link Class type} is non-<code>public</code> and
	 *         the caller isn't in the same <code>{@link Package runtime package}</code> as
	 *         the {@link Class type}
	 *     </li>
	 * </ul>
	 * to do an "uncovered" call.
	 * @since 0.1-build.1
	 */
	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	@SuppressWarnings("unused")
	public static <T> @NotNull(exception = NullPointerException.class) T as(
			@NotNull(
					value = "The specified latent instance is null!", exception = NullPointerException.class
			) final Object instance,
			@NotNull(
					value = "The specified cast type is null!", exception = NullPointerException.class
			) final Class<T> type
	                                                                       )
			throws Error, NullPointerException, IllegalArgumentException, SecurityException {

		// requireNonNull(instance, "The specified latent instance is null!");
		// requireNonNull(type, "The specified cast type is null!");

		checkForNull("The specified latent instance", instance);
		checkForNull("The specified cast type", type);

		if (!type.isInterface()) {

			throw new IllegalArgumentException(

					"The specified cast type (" +
					type.getTypeName() +
					") isn't an interface!"
			);
		}

		@NotNull(exception = NullPointerException.class)
		@SuppressWarnings({ "removal", "unchecked" })
		final T proxy = AccessController.doPrivileged(

				(PrivilegedAction<? extends T>) () -> (T) newProxyInstance(

						type.getClassLoader(),
						new Class<?>[] { type },
						new LatentHandler(instance)
				                                                          ),

				AccessController.getContext(),
				new RuntimePermission("getClassLoader"),
				new RuntimePermission("accessClassInPackage." + type.getPackageName()),

				// TODO: 20.09.2023 Implement here an algorithm to find the package name:
				new ReflectPermission("newProxyInPackage.*")
		                                             );

		return proxy;
	}

	/**
	 * Checks if the specified {@link Object object} is a "shadow" {@link Object object} and returns <code>true</code>
	 * if it is.
	 *
	 * <p>See the {@link Latent class documentation} for details.</p>
	 *
	 * @param instance An {@link Object object} to check if it's a "shadow" {@link Object object}.
	 *
	 * @return <code>true</code> if the specified object is a "shadow" {@link Object object};
	 * <code>false</code> - otherwise.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws SecurityException If the global <code>AccessControlContext</code> isn't initialized and the caller
	 * doesn't have permission
	 * <code>{@link SecurityPermission SecurityPermission}("createAccessControlContext")</code>
	 * to initialize it and also doesn't have permission
	 * <code>{@link RuntimePermission RuntimePermission}("accessClassInPackage" +
	 * instance.getClass().getPackageName())</code>
	 * to do an "uncovered" call.
	 * @since 0.1-build.1
	 */
	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	public static boolean isShadowed(@Nullable("Can be null anytime") final Object instance)
			throws Error, SecurityException {

		if (instance == null) {

			return false;
		}

		@NotNull(exception = NullPointerException.class)
		final Class<?> proxy = instance.getClass();

		if (isProxyClass(proxy)) {

			@NotNull(exception = NullPointerException.class)
			@SuppressWarnings("removal")
			final InvocationHandler handler = AccessController.doPrivileged(

					(PrivilegedAction<? extends InvocationHandler>) () -> getInvocationHandler(instance),
					AccessController.getContext(),
					new RuntimePermission("accessClassInPackage." + proxy.getPackageName())
			                                                               );

			return handler instanceof LatentHandler;
		}

		return false;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	@SuppressWarnings("unused")
	public static <T> @UnknownNullability(
			"Will be null if the specified proxy instance isn't a shadowed latent instance"
	) T find(
			@NotNull(
					value = "The specified proxy instance is null!", exception = NullPointerException.class
			) final Object proxy,
			@Nullable(value = "Can be null anytime") @SuppressWarnings(value = { "unused" }) final Class<T> cast
	        ) throws Error, NullPointerException {

		@UnknownNullability("Will be null if the specified proxy instance isn't a shadowed latent instance")
		@SuppressWarnings("unchecked")
		final T instance = (T) find(

				// requireNonNull(proxy, "The specified proxy instance is null!")

				checkForNull("The specified proxy instance", proxy)
		                           );

		return instance;
	}

	/**
	 * Returns an {@link Object object} to which refers the specified "shadow" {@link Object object}.
	 *
	 * <p>See the {@link Latent class documentation} for details.</p>
	 *
	 * @param proxy A "shadow" {@link Object object}.
	 *
	 * @return An {@link Object object} "interpreted" by the specified "shadow" {@link Object object}. If it isn't a
	 * valid "shadow" {@link Object object} - <code>null</code> will be returned.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws NullPointerException If the specified "shadow" {@link Object object} is <code>null</code>.
	 * @throws SecurityException If the global <code>AccessControlContext</code> isn't initialized and the caller
	 * doesn't have permission
	 * <code>{@link SecurityPermission SecurityPermission}("createAccessControlContext")</code>
	 * to initialize it and also doesn't have permission
	 * <code>{@link RuntimePermission RuntimePermission}("accessClassInPackage" +
	 * instance.getClass().getPackageName())</code>
	 * to do an "uncovered" call.
	 * @since 0.1-build.1
	 */
	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	public static @UnknownNullability(
			"Will be null if the specified proxy instance isn't a shadowed latent instance"
	) Object find(
			@NotNull(
					value = "The specified proxy instance is null!", exception = NullPointerException.class
			) final Object proxy
	             ) throws Error, NullPointerException, SecurityException {

		// requireNonNull(proxy, "The specified proxy instance is null!");

		checkForNull("The specified proxy instance", proxy);

		@NotNull(exception = NullPointerException.class)
		final Class<?> impl = proxy.getClass();

		if (isProxyClass(impl)) {

			@NotNull(exception = NullPointerException.class)
			@SuppressWarnings("removal")
			final InvocationHandler handler = AccessController.doPrivileged(

					(PrivilegedAction<? extends InvocationHandler>) () -> getInvocationHandler(proxy),
					AccessController.getContext(),
					new RuntimePermission("accessClassInPackage." + impl.getPackageName())
			                                                               );

			if (handler instanceof
					@NotNull(exception = NullPointerException.class) final LatentHandler latent) {

				return latent.shadowed();
			}
		}

		return null;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws Error {

		return getClass().getTypeName();
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(
			@Nullable("Can be null anytime") final Object another
	                     ) throws Error {

		return another instanceof Latent;
	}

	@AvailableSince("0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws Error {

		return hash(getClass());
	}

	@AvailableSince("0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@Deprecated(since = "0.1-build.1")
	@Override()
	@SuppressWarnings({ "super", "CloneDoesntCallSuperClone" })
	protected Latent clone() throws Error, CloneNotSupportedException {

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

	@AvailableSince("0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	private record LatentHandler(

			@NotNull(exception = NullPointerException.class) Object shadowed // <- A "shadowed" object

	) implements InvocationHandler {

		// Constructor:
		@AvailableSince("0.1-build.1")
		@Internal() // <- Internal context
		@NonBlocking() // <- Non-blocking context
		@Contract(pure = true)
		private LatentHandler(
				@NotNull(
						value = "The specified shadowed object is null!", exception = NullPointerException.class
				) final Object shadowed
		                     ) {

			// this.shadowed = requireNonNull(
			//
			// 		shadowed,
			// 		"The specified shadowed object is null!"
			//
			// ); // "Shadowed" objects can't be `null`!

			this.shadowed = checkForNull(
					"The specified shadowed object", shadowed); // "Shadowed" objects can't be `null`!
		}

		// A static method to instantiate a new instance of `LatentHandler` not by using the constructor:
		@AvailableSince(value = "0.1-build.1")
		@Internal() // <- Internal context
		@NonExtendable() // <- A non-extendable method
		@NonBlocking() // <- Non-blocking context
		@Contract(value = "_ -> new", pure = true)
		@SuppressWarnings("unused")
		public static @NotNull(exception = NullPointerException.class) LatentHandler getInstance(
				@NotNull(
						value = "The specified shadowed object is null!", exception = NullPointerException.class
				) final Object shadowed
		                                                                                        )
				throws Error, NullPointerException {

			return new LatentHandler(shadowed); // Instantiate a new `LatentHandler`
		}

		@AvailableSince("0.1-build.1")
		@Internal() // <- Internal context
		@NonExtendable() // <- A non-extendable method
		@NonBlocking() // <- Non-blocking context
		@Contract(value = " -> _", pure = true)
		@Override()
		public @NotNull(exception = NullPointerException.class) Object shadowed() {

			return shadowed;
		}

		@AvailableSince("0.1-build.1")
		@Internal() // <- Internal context
		@NonExtendable() // <- A non-extendable method
		@NonBlocking() // <- Non-blocking context
		@Contract("_, _, _ -> _")
		@Override()
		public @Nullable("Can be null anytime") Object invoke(
				@NotNull(exception = NullPointerException.class) final Object shadow, // <- A "shadow" object
				@NotNull(exception = NullPointerException.class) final Method method, // <- The called method
				@Nullable("Can be null anytime") final Object @Nullable("Can be null anytime") [] args
				// <- The passed arguments
		                                                     ) throws Error, LatentException {

			@NotNull(exception = NullPointerException.class)
			final Class<?> shadowClass = shadowed.getClass(); // <- The class of the "shadowed" object

			try {

				@NotNull(exception = NullPointerException.class)
				@SuppressWarnings("removal")
				final Method proxied = AccessController.doPrivileged(

						(PrivilegedExceptionAction<Method>) () -> shadowClass.getDeclaredMethod(

								method.getName(),
								method.getParameterTypes()
						                                                                       ),

						AccessController.getContext(),
						new RuntimePermission("accessDeclaredMembers"),
						new RuntimePermission("accessClassInPackage." + shadowClass.getPackageName())

				                                                    ); // <- The proxied method

				@NotNull(exception = NullPointerException.class)
				Class<?> obtained = proxied.getReturnType(), // <- The return value of the proxied method

						casted = method.getReturnType(); // <- The return value of the called method

				boolean defVoid = false; // <- If the current method returns primitive `void`

				// Wrap all primitive return values in their wrappers:
				if (obtained.isPrimitive() || casted.isPrimitive()) { // If any of return values is primitive...

					if (obtained == void.class) { // <- If it's primitive `void`...

						obtained = Void.class; // Wrap it in wrapper `Void`

					} else if (obtained == boolean.class) { // <- If it's primitive `boolean`...

						obtained = Boolean.class; // Wrap it in wrapper `Boolean`

					} else if (obtained == byte.class) { // <- If it's primitive `byte`...

						obtained = Byte.class; // Wrap it in wrapper `Byte`

					} else if (obtained == short.class) { // <- If it's primitive `short`...

						obtained = Short.class; // Wrap it in wrapper `Short`

					} else if (obtained == int.class) { // <- If it's primitive `int`...

						obtained = Integer.class; // Wrap it in wrapper `Integer`

					} else if (obtained == long.class) { // <- If it's primitive `long`...

						obtained = Long.class; // Wrap it in wrapper `Long`

					} else if (obtained == float.class) { // <- If it's primitive `float`...

						obtained = Float.class; // Wrap it in wrapper `Float`

					} else if (obtained == double.class) { // <- If it's primitive `double`...

						obtained = Double.class; // Wrap it in wrapper `Double`

					} else if (obtained == char.class) { // <- If it's primitive `char`...

						obtained = Character.class; // Wrap it in wrapper `Character`
					}

					if (casted == void.class) { // <- If it's primitive `void`...

						casted = Void.class; // Wrap it in wrapper `Void`
						defVoid = true; // Mark that the called method returns primitive `void`

					} else if (casted == boolean.class) { // <- If it's primitive `boolean`...

						casted = Boolean.class; // Wrap it in wrapper `Boolean`

					} else if (casted == byte.class) { // <- If it's primitive `byte`...

						casted = Byte.class; // Wrap it in wrapper `Byte`

					} else if (casted == short.class) { // <- If it's primitive `short`...

						casted = Short.class; // Wrap it in wrapper `Short`

					} else if (casted == int.class) { // <- If it's primitive `int`...

						casted = Integer.class; // Wrap it in wrapper `Integer`

					} else if (casted == long.class) { // <- If it's primitive `long`...

						casted = Long.class; // Wrap it in wrapper `Long`

					} else if (casted == float.class) { // <- If it's primitive `float`...

						casted = Float.class; // Wrap it in wrapper `Float`

					} else if (casted == double.class) { // <- If it's primitive `double`...

						casted = Double.class; // Wrap it in wrapper `Double`

					} else if (casted == char.class) { // <- If it's primitive `char`...

						casted = Character.class; // Wrap it in wrapper `Character`
					}
				}

				if (defVoid || casted.isAssignableFrom(obtained)) { // If the return values are compatible:

					// Try set the method to be accessible:
					if (!proxied.canAccess(Modifier.isStatic(proxied.getModifiers()) ? null : shadowed)) {

						@NotNull(exception = NullPointerException.class)
						@SuppressWarnings("removal")
						final Boolean accessible = AccessController.doPrivileged(

								(PrivilegedAction<Boolean>) proxied::trySetAccessible,
								AccessController.getContext(),
								new ReflectPermission("suppressAccessChecks")
						                                                        );

						if (!accessible) {

							throw new InaccessibleLatentException(

									"The proxied method (" +
									proxied +
									") is inaccessible!"

							); // If the method is inaccessible at all
						}
					}

					// Call the method:
					try {

						return proxied.invoke(shadowed, args); // Try call it

					} catch (@NotNull(exception = NullPointerException.class) final
					IllegalAccessException inaccessible) {

						throw new InaccessibleLatentException(

								"The proxied method (" +
								proxied +
								") is inaccessible!",
								inaccessible

						); // If the method is inaccessible at all

					} catch (@NotNull(exception = NullPointerException.class) final ExceptionInInitializerError init) {

						throw new LatentInitException(

								"The proxied method (" +
								proxied +
								") thrown an exception in initializer!",
								init.getException()

						); // If the class initializer thrown an exception

					} catch (@NotNull(exception = NullPointerException.class) final
					InvocationTargetException invocation) {

						throw new LatentTargetException(

								"The proxied method (" +
								proxied +
								") thrown an exception!",
								invocation.getTargetException()

						); // If the method thrown an exception
					}
				}

				throw new IncompatibleLatentException(

						"The called method (" +
						method +
						") is incompatible with the proxied one (" +
						proxied +
						")!"

				); // Incompatible signature (return value)

			} catch (@NotNull(exception = NullPointerException.class) final PrivilegedActionException notFound) {

				// Try set the method to be accessible:
				if (!method.canAccess(Modifier.isStatic(method.getModifiers()) ? null : shadow)) {

					@NotNull(exception = NullPointerException.class)
					@SuppressWarnings("removal")
					final Boolean accessible = AccessController.doPrivileged(

							(PrivilegedAction<Boolean>) method::trySetAccessible,
							AccessController.getContext(),
							new ReflectPermission("suppressAccessChecks")
					                                                        );

					if (!accessible) {

						throw new InaccessibleLatentException(

								"The proxied method (" +
								method +
								") is inaccessible!"

						); // <-- If the method is inaccessible at all
					}
				}

				// If the current method is from `Object` class:
				if (Objects.equals(method.getDeclaringClass(), Object.class)) {

					return switch (method.getName()) {

						case "toString" -> builtinToString(shadow, method, args); // <- Built-in `toString()`

						case "equals" -> builtinEquals(shadow, method, args); // <- Built-in `equals()`

						case "hashCode" -> builtinHashCode(shadow, method, args); // <- Built-in `hashCode()`

						default -> throw new LatentNotPresentException(

								"The proxied method (" +
								method +
								") has no compatible latents!"

						); // <- This should never happen!
					};
				}

				throw new LatentNotPresentException(

						"The proxied method (" +
						method +
						") has no compatible latents!",
						notFound.getException()

				); // Incompatible parameters/signatures

				// // Call the method if it isn't a method of `Object`:
				// try {
				//
				// 	return method.invoke(shadow, args); // Just try call it
				//
				// } catch (@NotNull(exception = NullPointerException.class) final IllegalArgumentException incompatible) {
				//
				// 	throw new LatentNotPresentException(
				//
				// 			"The proxied method (" +
				// 					method +
				// 			") has no compatible latents!",
				// 			incompatible
				//
				// 	); // Incompatible parameters/signatures
				//
				// } catch (@NotNull(exception = NullPointerException.class) final IllegalAccessException inaccessible) {
				//
				// 	throw new InaccessibleLatentException(
				//
				// 			"The proxied method (" +
				// 					method +
				// 			") is inaccessible!",
				// 			inaccessible
				//
				// 	); // If the method is inaccessible at all
				//
				// } catch (@NotNull(exception = NullPointerException.class) final ExceptionInInitializerError init) {
				//
				// 	throw new LatentInitException(
				//
				// 			"The proxied method (" +
				// 					method +
				// 			") thrown an exception in initializer!",
				// 			init.getException()
				//
				// 	); // If the class initializer thrown an exception
				//
				// } catch (@NotNull(exception = NullPointerException.class) final InvocationTargetException invocation) {
				//
				// 	throw new LatentTargetException(
				//
				// 			"The proxied method (" +
				// 					method +
				// 			") thrown an exception!",
				// 			invocation.getTargetException()
				//
				// 	); // If the method thrown an exception
				// }

			} catch (@NotNull(exception = NullPointerException.class) final SecurityException permission) {

				throw new LatentPermException(

						"You don't have permission to call the proxied method (" +
						method +
						")!",
						permission

				); // The caller doesn't have permission to do this call
			}
		}

		@AvailableSince("0.1-build.1")
		@NonExtendable() // <- A non-extendable method
		@NonBlocking() // <- Non-blocking context
		@Contract(value = " -> _", pure = true)
		@Override()
		public @NotNull(exception = NullPointerException.class) String toString() throws Error {

			return getClass().getTypeName() +
			       "[present = " +
			       shadowed + // <- Pass the "shadowed" object to the resulting string
			       "]";
		}

		@AvailableSince("0.1-build.1")
		@NonExtendable() // <- A non-extendable method
		@NonBlocking() // <- Non-blocking context
		@Contract(value = "null -> false; !null -> _", pure = true)
		@Override()
		public boolean equals(
				@Nullable("Can be null anytime") final Object another
		                     ) throws Error {

			return another instanceof
					       final LatentHandler other && // <- Check if the another object is an instance of `Latent`
			       shadowed == other.shadowed; // <- Check if the "shadowed" objects are the same object
		}

		@AvailableSince("0.1-build.1")
		@NonExtendable() // <- A non-extendable method
		@NonBlocking() // <- Non-blocking context
		@Contract(value = " -> _", pure = true)
		@Override()
		public int hashCode() throws Error {

			// Note: The `hash()` method of the `Objects` class is used
			//       because even if the only argument is passed to it,
			//       the hash code is still counted according to
			//       the hash code formula, so the code will be valid, short and clear.
			//       This is exactly what is required in this implementation!
			return hash(identityHashCode(shadowed)); // Calculate the hash code
		}

		// Built-in `toString()`:
		@AvailableSince("0.1-build.2")
		@Internal() // <- Internal context
		@NonExtendable() // <- A non-extendable method
		@NonBlocking() // <- Non-blocking context
		@Contract(value = "_, _, _ -> _", pure = true)
		private @NotNull(exception = NullPointerException.class) String builtinToString(
				@NotNull(exception = NullPointerException.class) final Object proxy,
				@NotNull(exception = NullPointerException.class) final Method method,
				@Nullable("Can be null anytime") final Object @Nullable("Can be null anytime") ... args
		                                                                               ) throws Error, LatentException {

			// Signature check:
			if (args != null && args.length > 0) { // If the method accepts any parameters...

				throw new LatentNotPresentException(

						"The proxied method (" +
						method +
						") has no compatible latents!"

				); // Invalid arguments/signature!
			}

			// Built-in implementation of `toString()`:
			return toIdentityString(proxy); // <- Default `toString()`
		}

		// Built-in `equals()`:
		@AvailableSince("0.1-build.2")
		@Internal() // <- Internal context
		@NonExtendable() // <- A non-extendable method
		@NonBlocking() // <- Non-blocking context
		@Contract(value = "_, _, _ -> _", pure = true)
		private boolean builtinEquals(
				@NotNull(exception = NullPointerException.class) final Object proxy,
				@NotNull(exception = NullPointerException.class) final Method method,
				@Nullable("Can be null anytime") final Object @Nullable(
						"Can be null anytime"
				) ... args
		                             ) throws Error, LatentException {

			// Signature check:
			if (args == null || args.length != 1) { // If the method accepts more or less than 1 parameter...

				throw new LatentNotPresentException(

						"The proxied method (" +
						method +
						") has no compatible latents!"

				); // Invalid arguments/signature!
			}

			// Built-in implementation of `equals()`:
			return proxy == args[0] || // <- Default `equals()`
			       shadowed == args[0] || shadowed == find(proxy); // <- Special `equals()`
		}

		// Built-in `hashCode()`:
		@AvailableSince(value = "0.1-build.2")
		@Internal() // <- Internal context
		@NonExtendable() // <- A non-extendable method
		@NonBlocking() // <- Non-blocking context
		@Contract(value = "_, _, _ -> _", pure = true)
		private int builtinHashCode(
				@NotNull(exception = NullPointerException.class) final Object proxy,
				@NotNull(exception = NullPointerException.class) final Method method,
				@Nullable("Can be null anytime") final Object @Nullable(
						"Can be null anytime"
				) ... args
		                           ) throws Error, LatentException {

			// Signature check:
			if (args != null && args.length > 0) { // If the method accepts any parameters...

				throw new LatentNotPresentException(

						"The proxied method (" +
						method +
						") has no compatible latents!"

				); // Invalid arguments/signature!
			}

			// Built-in implementation of `hashCode()`:
			return identityHashCode(proxy); // <- Default `hashCode()`
		}
	}
}
