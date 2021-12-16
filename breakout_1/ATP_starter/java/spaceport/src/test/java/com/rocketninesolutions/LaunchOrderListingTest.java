package com.rocketninesolutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaunchOrderListingTest {

    //TODO - Use the Stub Recipe to test that launches are sorted correctly
    @Test
    public void LaunchesAre_SortedByDestination_DestinationsAreUnique() {
        // Step 1. Create LaunchInfoProviderStub (that implements ISpacelineLaunchInfoProvider)
        LaunchedFlightsTest.MockLaunchInfoProvider provider = new LaunchedFlightsTest.MockLaunchInfoProvider();

        // Step 2 & 3 & 4. Create SUT - SpaceportDepartureBoard, using Constructor Injection
        SpaceportDepartureBoard board = new SpaceportDepartureBoard(provider);
        // Exercising this behavior happens during construction of the System Under Test

        // Step 5. Verify the results are sorted correctly
        Assertions.fail("TODO - test the info sorting behavior");
        assertEquals(-1, board.getLaunchList().get(0).getDestination().compareTo(board.getLaunchList().get(1).getDestination()));
    }
}
