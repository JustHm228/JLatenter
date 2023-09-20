/*
 * Copyright (c) 2023 JustHuman228
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

import static java.lang.Integer.*;
import static java.lang.System.*;
import java.lang.reflect.*;
import static java.lang.reflect.Proxy.*;
import java.security.*;
import java.util.*;
import static java.util.Objects.requireNonNull;
import static java.util.Objects.hash;
import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.*;
import java.lang.*;

@AvailableSince(value = "0.1-build.1")
@NonExtendable()
@NonBlocking()
public final class Latent {

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	private Latent() throws Error, UnsupportedOperationException {

		super();

		throw new UnsupportedOperationException(

				"An instance of this type (" +
						getClass().getTypeName() +
				") can't be instantiated with a constructor!"
		);
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	public static @NotNull(exception = NullPointerException.class) Object as(
			@NotNull(value = "The specified latent instance is null!") final Object instance,
			@NotNull(value = "The specified cast type is null!", exception = NullPointerException.class) final Object type
	) throws Error, NullPointerException, IllegalArgumentException {

		requireNonNull(instance, "The specified latent instance is null!");
		requireNonNull(type, "The specified cast type is null!");

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
	 *
	 * @return A "shadow" of the specified {@link Object object}.
	 * @param <T> The specified {@link Class type} as a generic.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws NullPointerException If any specified parameter is <code>null</code>.
	 * @throws IllegalArgumentException If the specified {@link Class type} isn't an <code>interface</code>.
	 * @throws SecurityException If the global <code>AccessControlContext</code> isn't
	 * 							 initialized and the caller doesn't have
	 * 							 permission <code>{@link SecurityPermission SecurityPermission}("createAccessControlContext")</code>
	 * 							 to initialize it and doesn't have such permissions:
	 * 							 <ul>
	 * 							     <li>
	 * 							         <code>{@link RuntimePermission RuntimePermission}("getClassLoader")</code> -
	 * 							         if the specified {@link Class type} is loaded by
	 * 							         the bootstrap {@link ClassLoader classloader} and
	 * 							         the caller's {@link ClassLoader classloader} isn't
	 * 							         the {@link ClassLoader same}
	 * 							     </li>
	 * 							     <li>
	 * 							         <code>{@link RuntimePermission RuntimePermission}("accessClassInPackage." + type.getPackageName())</code> -
	 * 							         if the specified {@link Class type}'s {@link ClassLoader classloader} isn't
	 * 							         the {@link ClassLoader same} as or an {@link ClassLoader ancestor} of
	 * 							         the caller's {@link ClassLoader classloader}
	 * 							     </li>
	 * 							     <li>
	 * 							         <code>{@link RuntimePermission RuntimePermission}("newProxyInPackage." + proxyPkg)</code> -
	 * 							         if the specified {@link Class type} is non-<code>public</code> and
	 * 							         the caller isn't in the same <code>{@link Package runtime package}</code> as
	 * 							         the {@link Class type}
	 * 							     </li>
	 * 							 </ul>
	 * 							 to do an "uncovered" call.
	 *
	 * @apiNote _
	 * @implSpec _
	 * @implNote _
	 *
	 * @since 0.1-build.1
	 */
	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	public static <T> @NotNull(exception = NullPointerException.class) T as(
			@NotNull(value = "The specified latent instance is null!", exception = NullPointerException.class) final Object instance,
			@NotNull(value = "The specified cast type is null!", exception = NullPointerException.class) final Class<T> type
	) throws Error, NullPointerException, IllegalArgumentException, SecurityException {

		requireNonNull(instance, "The specified latent instance is null!");
		requireNonNull(type, "The specified cast type is null!");

		if (!type.isInterface()) {

			throw new IllegalArgumentException(

					"The specified cast type (" +
							type.getTypeName() +
					") isn't an interface!"
			);
		}

		@NotNull(exception = NullPointerException.class)
		@SuppressWarnings(value = { "removal", "unchecked" })
		final T proxy = AccessController.doPrivileged(

		   (PrivilegedAction<? extends T>) () -> (T) newProxyInstance(

				type.getClassLoader(),
				new Class[] { type },
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
	 * Checks if the specified {@link Object object} is a "shadow" {@link Object object} and returns <code>true</code> if it is.
	 *
	 * <p>See the {@link Latent class documentation} for details.</p>
	 *
	 * @param instance An {@link Object object} to check if it's a "shadow" {@link Object object}.
	 *
	 * @return <code>true</code> if the specified object is a "shadow" {@link Object object};
	 * 		   <code>false</code> - otherwise.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws SecurityException If the global <code>AccessControlContext</code> isn't
	 * 							 initialized and the caller doesn't have permission
	 * 							 <code>{@link SecurityPermission SecurityPermission}("createAccessControlContext")</code>
	 * 							 to initialize it and also doesn't have permission
	 * 							 <code>{@link RuntimePermission RuntimePermission}("accessClassInPackage" + instance.getClass().getPackageName())</code>
	 * 							 to do an "uncovered" call.
	 *
	 * @apiNote _
	 * @implSpec _
	 * @implNote _
	 *
	 * @since 0.1-build.1
	 */
	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	public static boolean isShadowed(
			@Nullable(value = "Can be null anytime") final Object instance
	) throws Error, SecurityException {

		if (instance == null) {

			return false;
		}

		@NotNull(exception = NullPointerException.class)
		final Class<?> proxy = instance.getClass();

		if (isProxyClass(proxy)) {

			@NotNull(exception = NullPointerException.class)
			@SuppressWarnings(value = { "removal" })
			final InvocationHandler handler = AccessController.doPrivileged(

					(PrivilegedAction<? extends InvocationHandler>) () -> getInvocationHandler(instance),
					AccessController.getContext(),
					new RuntimePermission("accessClassInPackage." + proxy.getPackageName())
			);

			return handler instanceof LatentHandler;
		}

		return false;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_, _ -> _", pure = true)
	@Deprecated(since = "0.1-build.2")
	public static <T> @UnknownNullability(value = "Will be null if the specified proxy instance isn't a shadowed latent instance") T find(
			@NotNull(value = "The specified proxy instance is null!", exception = NullPointerException.class) final Object proxy,
			@Nullable(value = "Can be null anytime") @SuppressWarnings(value = { "unused" }) final Class<T> cast
	) throws Error, NullPointerException {

		@UnknownNullability(value = "Will be null if the specified proxy instance isn't a shadowed latent instance")
		@SuppressWarnings(value = { "unchecked" })
		final T instance = (T) find(

				requireNonNull(proxy, "The specified proxy instance is null!")
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
	 * @return An {@link Object object} "interpreted" by the specified "shadow" {@link Object object}.
	 * 		   If it isn't a valid "shadow" {@link Object object} - <code>null</code> will be returned.
	 *
	 * @throws Error If something went wrong in the JVM.
	 * @throws NullPointerException If the specified "shadow" {@link Object object} is <code>null</code>.
	 * @throws SecurityException If the global <code>AccessControlContext</code> isn't
	 * 							 initialized and the caller doesn't have permission
	 * 							 <code>{@link SecurityPermission SecurityPermission}("createAccessControlContext")</code>
	 * 							 to initialize it and also doesn't have permission
	 * 							 <code>{@link RuntimePermission RuntimePermission}("accessClassInPackage" + instance.getClass().getPackageName())</code>
	 * 							 to do an "uncovered" call.
	 *
	 * @apiNote _
	 * @implSpec _
	 * @implNote _
	 *
	 * @since 0.1-build.1
	 */
	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "_ -> _", pure = true)
	public static @UnknownNullability(value = "Will be null if the specified proxy instance isn't a shadowed latent instance") Object find(
			@NotNull(value = "The specified proxy instance is null!", exception = NullPointerException.class) final Object proxy
	) throws Error, NullPointerException, SecurityException {

		requireNonNull(proxy, "The specified proxy instance is null!");

		@NotNull(exception = NullPointerException.class)
		final Class<?> impl = proxy.getClass();

		if (isProxyClass(impl)) {

			@NotNull(exception = NullPointerException.class)
			@SuppressWarnings(value = { "removal" })
			final InvocationHandler handler = AccessController.doPrivileged(

					(PrivilegedAction<? extends InvocationHandler>) () -> getInvocationHandler(proxy),
					AccessController.getContext(),
					new RuntimePermission("accessClassInPackage." + impl.getPackageName())
			);

			if (handler instanceof
					@NotNull(exception = NullPointerException.class) final LatentHandler latent) {

				return latent.present();
			}
		}

		return null;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public @NotNull(exception = NullPointerException.class) String toString() throws Error {

		return getClass().getTypeName();
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = "null -> false; !null -> _", pure = true)
	@Override()
	public boolean equals(
			@Nullable(value = "Can be null anytime") final Object another
	) throws Error {

		return another instanceof Latent;
	}

	@AvailableSince(value = "0.1-build.1")
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> _", pure = true)
	@Override()
	public int hashCode() throws Error {

		return hash(getClass());
	}

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	@Contract(value = " -> fail", pure = true)
	@Deprecated(since = "0.1-build.1")
	@Override()
	protected Latent clone() throws Error, CloneNotSupportedException {

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
	protected void finalize() throws Throwable {

		super.finalize();
	}

	@AvailableSince(value = "0.1-build.1")
	@Internal()
	@NonExtendable()
	@NonBlocking()
	private record LatentHandler(

			@NotNull(exception = NullPointerException.class) Object present

	) implements InvocationHandler {

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonBlocking()
		@Contract(pure = true)
		private LatentHandler(
				@NotNull(value = "The specified latent instance is null!", exception = NullPointerException.class) final Object present
		) {

			this.present = requireNonNull(

					present,
					"The specified latent instance is null!"
			);
		}

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		@Contract(value = "_ -> new", pure = true)
		public static @NotNull(exception = NullPointerException.class) LatentHandler getInstance(
				@NotNull(value = "The specified latent instance is null!", exception = NullPointerException.class) final Object present
		) throws Error, NullPointerException {

			return new LatentHandler(present);
		}

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		@Contract(value = " -> _", pure = true)
		@Override()
		public @NotNull(exception = NullPointerException.class) Object present() {

			return present;
		}

		@AvailableSince(value = "0.1-build.1")
		@Internal()
		@NonExtendable()
		@NonBlocking()
		@Contract(value = "_, _, _ -> _")
		@Override()
		public @Nullable(value = "Can be null anytime") Object invoke(
				@NotNull(exception = NullPointerException.class) final Object proxy,
				@NotNull(exception = NullPointerException.class) final Method method,
				@Nullable(value = "Can be null anytime") final Object @Nullable(value = "Can be null anytime") [] args
		) throws Error, LatentNotPresentException, IncompatibleLatentException,
				InaccessibleLatentException, LatentInitException, LatentTargetException {

			@NotNull(exception = NullPointerException.class)
			Class<?> cast = present.getClass();

			try {

				@SuppressWarnings(value = { "removal" })
				final Method called = AccessController.doPrivileged(

						(PrivilegedExceptionAction<Method>) () -> cast.getDeclaredMethod(

								method.getName(),
								method.getParameterTypes()
						),

						AccessController.getContext(),
						new RuntimePermission("accessDeclaredMembers"),
						new RuntimePermission("accessClassInPackage." + cast.getPackageName())
				);

				@NotNull(exception = NullPointerException.class)
				Class<?> result = called.getReturnType(),

						 proxied = method.getReturnType();

				if (result.isPrimitive() || proxied.isPrimitive()) {

					if (result == void.class) {

						result = Void.class;

					} else if (result == boolean.class) {

						result = Boolean.class;

					} else if (result == byte.class) {

						result = Byte.class;

					} else if (result == short.class) {

						result = Short.class;

					} else if (result == int.class) {

						result = Integer.class;

					} else if (result == long.class) {

						result = Long.class;

					} else if (result == float.class) {

						result = Float.class;

					} else if (result == double.class) {

						result = Double.class;

					} else if (result == char.class) {

						result = Character.class;
					}

					if (proxied == void.class) {

						proxied = Void.class;

					} else if (proxied == boolean.class) {

						proxied = Boolean.class;

					} else if (proxied == byte.class) {

						proxied = Byte.class;

					} else if (proxied == short.class) {

						proxied = Short.class;

					} else if (proxied == int.class) {

						proxied = Integer.class;

					} else if (proxied == long.class) {

						proxied = Long.class;

					} else if (proxied == float.class) {

						proxied = Float.class;

					} else if (proxied == double.class) {

						proxied = Double.class;

					} else if (proxied == char.class) {

						proxied = Character.class;
					}
				}

				if (proxied == Void.class || proxied.isAssignableFrom(result)) {

					if (!called.canAccess(Modifier.isStatic(called.getModifiers()) ? null : present)) {

						@NotNull(exception = NullPointerException.class)
						@SuppressWarnings(value = { "removal" })
						final Boolean accessible = AccessController.doPrivileged(

								(PrivilegedAction<Boolean>) called::trySetAccessible,
								AccessController.getContext(),
								new ReflectPermission("suppressAccessChecks")
						);

						if (!accessible) {

							throw new InaccessibleLatentException(

									"The used method (" +
											called +
									") is inaccessible!"
							);
						}
					}

					try {

						return called.invoke(present, args);

					} catch (@NotNull(exception = NullPointerException.class) final IllegalAccessException inaccessible) {

						throw new InaccessibleLatentException(

								"The used method (" +
										called +
								") is inaccessible!",
								inaccessible
						);

					} catch (@NotNull(exception = NullPointerException.class) final ExceptionInInitializerError init) {

						throw new LatentInitException(

								"The used method (" +
										called +
								") thrown an exception in initializer!",
								init.getException()
						);

					} catch (@NotNull(exception = NullPointerException.class) final InvocationTargetException invocation) {

						throw new LatentTargetException(

								"The used method (" +
										called +
								") thrown an exception!",
								invocation.getTargetException()
						);
					}
				}

				throw new IncompatibleLatentException(

						"The proxied method (" +
								method +
						") is incompatible with found (" +
								called +
						")!"
				);

			} catch (@NotNull(exception = NullPointerException.class) final PrivilegedActionException notFound) {

				// Try set the method to be accessible:
				if (!method.canAccess(Modifier.isStatic(method.getModifiers()) ? null : present)) {

					@NotNull(exception = NullPointerException.class)
					@SuppressWarnings(value = { "removal" })
					final Boolean accessible = AccessController.doPrivileged(

							(PrivilegedAction<Boolean>) method::trySetAccessible,
							AccessController.getContext(),
							new ReflectPermission("suppressAccessChecks")
					);

					if (!accessible) {

						throw new InaccessibleLatentException(

								"The used method (" +
										method +
								") is inaccessible!"

						); // <-- If the method is inaccessible at all
					}
				}

				// If the current method is from `Object` class:
				if (Objects.equals(method.getDeclaringClass(), Object.class)) {

					switch (method.getName()) {

						case "toString" -> { // Built-in `toString()` implementation:

							if (args != null && args.length > 0) {

								throw new LatentNotPresentException(

										"The proxied method (" +
												method +
										") has no compatible latents!"

								); // <-- Invalid arguments!
							}

							return proxy.getClass().getName() +
									"@" +
									toHexString(identityHashCode(proxy)); // <-- Default `Object`'s implementation
						}

						case "equals" -> { // Built-in `equals()` implementation:

							if (args == null || args.length != 1) {

								throw new LatentNotPresentException(

										"The proxied method (" +
												method +
										") has no compatible latents!"

								); // <-- Invalid arguments!
							}

							return proxy == args[0]; // <-- Default `Object`'s implementation
						}

						case "hashCode" -> { // Built-in `hashCode()` implementation:

							if (args != null && args.length > 0) {

								throw new LatentNotPresentException(

										"The proxied method (" +
												method +
										") has no compatible latents!"

								); // <-- Invalid arguments!
							}

							return identityHashCode(proxy); // <-- Default `Object`'s implementation
						}
					}
				}

				// If it isn't a method of `Object`:
				try {

					return method.invoke(present, args); // Just try to call it

				} catch (@NotNull(exception = NullPointerException.class) final IllegalArgumentException incompatible) {

					throw new LatentNotPresentException(

							"The proxied method (" +
									method +
							") has no compatible latents!",
							incompatible

					); // Incompatible signatures!

				} catch (@NotNull(exception = NullPointerException.class) final IllegalAccessException inaccessible) {

					throw new InaccessibleLatentException(

							"The used method (" +
									method +
							") is inaccessible!",
							inaccessible

					); // Method is inaccessible!

				} catch (@NotNull(exception = NullPointerException.class) final ExceptionInInitializerError init) {

					throw new LatentInitException(

							"The used method (" +
									method +
							") thrown an exception in initializer!",
							init.getException()

					); // Exception in initializer!

				} catch (@NotNull(exception = NullPointerException.class) final InvocationTargetException invocation) {

					throw new LatentTargetException(

							"The used method (" +
									method +
							") thrown an exception!",
							invocation.getTargetException()

					); // The method has thrown an exception!
				}
			}
		}

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@NonBlocking()
		@Contract(value = " -> _", pure = true)
		@Override()
		public @NotNull(exception = NullPointerException.class) String toString() throws Error {

			return getClass().getTypeName() +
					"[present = " +
					present +
					"]";
		}

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@NonBlocking()
		@Contract(value = "null -> false; !null -> _", pure = true)
		@Override()
		public boolean equals(
				@Nullable(value = "Can be null anytime") final Object another
		) throws Error {

			return another instanceof
					final LatentHandler other &&
					present == other.present;
		}

		@AvailableSince(value = "0.1-build.1")
		@NonExtendable()
		@NonBlocking()
		@Contract(value = " -> _", pure = true)
		@Override()
		public int hashCode() throws Error {

			return hash(identityHashCode(present));
		}
	}
}
