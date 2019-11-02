package tally.ui;

import tally.algo.BallotPaper;

public interface TallyController {
    void gotoOperationPanel();
    void gotoLoginPanel();
    void gotoPhysicalKeyPanel();
    void gotoSettingPanel();
    void gotoExcludePanel();

    void tallyVotes();
}