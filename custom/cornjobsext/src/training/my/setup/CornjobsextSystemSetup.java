/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package training.my.setup;

import static training.my.constants.CornjobsextConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import training.my.constants.CornjobsextConstants;
import training.my.service.CornjobsextService;


@SystemSetup(extension = CornjobsextConstants.EXTENSIONNAME)
public class CornjobsextSystemSetup
{
	private final CornjobsextService cornjobsextService;

	public CornjobsextSystemSetup(final CornjobsextService cornjobsextService)
	{
		this.cornjobsextService = cornjobsextService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		cornjobsextService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return CornjobsextSystemSetup.class.getResourceAsStream("/cornjobsext/sap-hybris-platform.png");
	}
}
