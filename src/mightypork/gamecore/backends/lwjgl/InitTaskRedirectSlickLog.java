package mightypork.gamecore.backends.lwjgl;


import mightypork.gamecore.core.init.InitTask;
import mightypork.gamecore.core.init.OptionalInitTask;
import mightypork.utils.logging.writers.LogWriter;


/**
 * Initializer that redirects slick logging to main logger.
 *
 * @author Ondřej Hruška (MightyPork)
 */
@OptionalInitTask
public class InitTaskRedirectSlickLog extends InitTask {

	@Override
	public void run()
	{
		final LogWriter ml = mightypork.utils.logging.Log.getMainLogger();
		final SlickLogRedirector slr = new SlickLogRedirector(ml);
		org.newdawn.slick.util.Log.setLogSystem(slr);
	}


	@Override
	public String getName()
	{
		return "slick_log";
	}


	@Override
	public String[] getDependencies()
	{
		return new String[] { "log" };
	}


	@Override
	public int getPriority()
	{
		return PRIO_FIRST;
	}
}
