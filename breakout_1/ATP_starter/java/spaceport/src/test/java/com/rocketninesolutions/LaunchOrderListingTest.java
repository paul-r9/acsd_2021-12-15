package com.rocketninesolutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaunchOrderListingTest {

    private LaunchInfo createLaunchInfo(String destination, LocalDateTime dateTime)
    {
        LaunchInfo launchInfo = new LaunchInfo(UUID.randomUUID());
        launchInfo.setDestination(destination);
        launchInfo.setTime(dateTime);
        //Add other fields here
        return launchInfo;
    }

    //TODO - Use the Stub Recipe to test that launches are sorted correctly
    @Test
    public void LaunchesAre_SortedByDestination_DestinationsAreUnique() {
        // Step 1. Create LaunchInfoProviderStub (that implements ISpacelineLaunchInfoProvider)
        LaunchedFlightsTest.MockLaunchInfoProvider provider = new LaunchedFlightsTest.MockLaunchInfoProvider();

        provider.getCurrentLaunches().add(createLaunchInfo("test2", LocalDateTime.now()));
        provider.getCurrentLaunches().add(createLaunchInfo("test1", LocalDateTime.now()));
        // Step 2 & 3 & 4. Create SUT - SpaceportDepartureBoard, using Constructor Injection
        SpaceportDepartureBoard board = new SpaceportDepartureBoard(provider);
        // Exercising this behavior happens during construction of the System Under Test

        // Step 5. Verify the results are sorted correctly
        //Assertions.fail("TODO - test the info sorting behavior");
        assertEquals("test1", board.getLaunchList().get(0).getDestination());
				assertEquals("test2", board.getLaunchList().get(1).getDestination());
    }

    @Test
    public void LaunchesAre_SortedByTime_TimesAreOrdered() {
        // Step 1. Create LaunchInfoProviderStub (that implements ISpacelineLaunchInfoProvider)
        LaunchedFlightsTest.MockLaunchInfoProvider provider = new LaunchedFlightsTest.MockLaunchInfoProvider();

        provider.getCurrentLaunches().add(createLaunchInfo("test1", LocalDateTime.of(2021, 11, 10, 10, 10)));
        provider.getCurrentLaunches().add(createLaunchInfo("test1", LocalDateTime.of(2021, 10, 10, 10, 10)));
        // Step 2 & 3 & 4. Create SUT - SpaceportDepartureBoard, using Constructor Injection
        SpaceportDepartureBoard board = new SpaceportDepartureBoard(provider);
        // Exercising this behavior happens during construction of the System Under Test



        // Step 5. Verify the results are sorted correctly
        //Assertions.fail("TODO - test the info sorting behavior");
        assertEquals("test1", board.getLaunchList().get(0).getDestination());
        assertEquals("test1", board.getLaunchList().get(1).getDestination());

        assertEquals("2021-10-10T10:10", board.getLaunchList().get(0).getTime().toString());
        assertEquals("2021-11-10T10:10", board.getLaunchList().get(1).getTime().toString());
    }
}
