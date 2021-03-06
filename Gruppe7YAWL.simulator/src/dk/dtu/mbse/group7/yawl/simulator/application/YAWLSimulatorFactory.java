package dk.dtu.mbse.group7.yawl.simulator.application;

import org.pnml.tools.epnk.applications.ApplicationFactory;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;

import dk.dtu.mbse.group7.yawl.YAWLNet;

/**
 * The application factory which is plugged in for registering the YAWL
 * simulator with the ePNK (see plugin.xml).
 * 
 * @author Nicki Nylin
 *
 */
public class YAWLSimulatorFactory extends ApplicationFactory {

	public YAWLSimulatorFactory() {
		super();
	}

	@Override
	public String getName() {
		return "YAWL Simulator";
	}

	@Override
	public String getDescription() {
		return "A simple simulator for the YAWL nets";
	}

	@Override
	public boolean isApplicable(PetriNet net) {
		return net.getType() instanceof YAWLNet;
	}

	@Override
	public ApplicationWithUIManager startApplication(PetriNet net) {
		return new YAWLSimulator(net);
	}

}
