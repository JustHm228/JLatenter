module jlatenter.base {

	requires java.base;
	requires static org.jetbrains.annotations;

	exports com.github.justhm228.jlatenter.base;
	exports com.github.justhm228.jlatenter.latent;

	opens com.github.justhm228.jlatenter.base to jlatenter.test;
	opens com.github.justhm228.jlatenter.latent to jlatenter.test;
}
