%%%%%%%%%%%%%
%% Comparator
%%%%%%%%%%%%%

Using Eclipse IDE.
1. Download the project "MetaModelComparison.zip" from branch "comparator"
2. Unzip de project
2. Import project by using "File" > "Import" > "General" > "Existing projects into workspace"
3. To use the comparator class:
		"src/comparator/MMComparator.java" > "Run As..." > "Java Application"
4. To use the counter class:
		"src/comparator/counters/BasicMetricCounter.java" > "Run As..." > "Java Application"

%%%%%%%%%%%%%%%%%%%
%% Input: Artifacts
%%%%%%%%%%%%%%%%%%%
Location of the artifacts collected from the experiment: "\ecores" folder
Structure of the folder:
\ecores
	\Control-Group-Ecores > Artifacts collected in the control group.
	\Experiment-Group-Ecores > Artifacts collected in the experimental group.
	\flattened > Flattened version of the artifacts (they do not validate)
	000.ecore > Solution used as a reference in the case study.

%%%%%%%%%%%%%%%%%
%% Outputs: \logs
%%%%%%%%%%%%%%%%%
Structure of the folder \logs:
\logs
	\exact-emfcompare
		\matches: ".txt" files with the elements that match in the comparison with the ecore "000.ecore".
		\matches-matrix: ".txt" files with the elements that match in the comparison among meta-models
		\unmatches: ".txt" files with the elements that unmatch in the comparison with the ecore "000.ecore"
		\unmatches-matrix: ".txt" files with the elements that unmatch in the comparison among meta-models

The rest of the folders are variations of this matching strategy using the flattened version of the meta-models collected and the matching method based on a inexact matching method.
