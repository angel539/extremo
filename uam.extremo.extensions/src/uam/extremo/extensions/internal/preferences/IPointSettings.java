package uam.extremo.extensions.internal.preferences;

public interface IPointSettings {
	String getName();
	
	int getRelevanceOfSynonyms(); //R1
	int getRelevanceOfPaths(); //R2
	int getRelevanceOfDefinitions(); //R3
	int getRelevanceOfUsages(); //R4
	int getRelevanceOfInformationSharing(); //R5
	
	int getMaxWeight();
}
