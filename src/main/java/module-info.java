/**
 * Stores all the implementation of the JLatenter library.
 *
 * <p>
 * Since 0.1-build.1, every class and every method can be accessed by the user are stored here. Utilities which aren't
 * stored in this module are counting as internal so the user can't and shouldn't access them.
 * </p>
 *
 * <i>
 * The main reason of such "packaging" was to isolate unit tests from the user even if they won't be cleared
 * automatically. So, if you want, you can count the usage of modules here redundant.
 * </i>
 *
 * <p>
 * <b>
 * Note: This module also uses <code>org.jetbrains:annotations:24.0.1</code>'s annotations to enable a better static
 * analysis, but it isn't required, so if you don't provide the dependency yourself, then all annotations will be
 * ignored, and if you provide it - your IDE should enable better static analysis automatically.
 * </b>
 * </p>
 *
 * @since 0.1-build.1
 */
module jlatenter.base {

	requires java.base;
	requires static org.jetbrains.annotations;

	exports com.github.justhm228.jlatenter.base;
	exports com.github.justhm228.jlatenter.latent;

	opens com.github.justhm228.jlatenter.base to jlatenter.test;
	opens com.github.justhm228.jlatenter.latent to jlatenter.test;
}
