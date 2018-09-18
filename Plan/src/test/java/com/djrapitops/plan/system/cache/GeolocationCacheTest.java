package com.djrapitops.plan.system.cache;

import com.djrapitops.plan.Plan;
import com.djrapitops.plan.api.exceptions.EnableException;
import com.djrapitops.plan.system.PlanSystem;
import com.djrapitops.plugin.StaticHolder;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import utilities.mocks.BukkitMockUtil;

import static org.junit.Assert.assertEquals;

/**
 * Test for GeolocationCache.
 *
 * @author Rsl1122
 */
public class GeolocationCacheTest {

    @ClassRule
    public static TemporaryFolder temporaryFolder = new TemporaryFolder();
    private static Plan planMock;

    @BeforeClass
    public static void setUpClass() throws Exception {
        BukkitMockUtil mockUtil = BukkitMockUtil.setUp()
                .withDataFolder(temporaryFolder.getRoot())
                .withLogging()
                .withPluginDescription()
                .withResourceFetchingFromJar()
                .withServer();
        planMock = mockUtil.getPlanMock();
        StaticHolder.saveInstance(GeolocationCacheTest.class, planMock.getClass());
    }

    @Test
    @Ignore
    public void testGeolocationCache() throws EnableException {
//        Settings.WEBSERVER_PORT.setTemporaryValue(9005);
        PlanSystem system = null; //TODO
        try {
            system.enable();

            String expected = "Germany";
            String result = GeolocationCache.getCountry("141.52.255.1");
            assertEquals(expected, result);
        } finally {
            system.disable();
        }
    }

}