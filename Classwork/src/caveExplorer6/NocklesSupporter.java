package caveExplorer6;

public interface NocklesSupporter {

	int getTotalTreasure();

	BenNocklesPlot[][] getPlots();

	int[] getCoordInput();

	void reveal(BenNocklesPlot p);

}
