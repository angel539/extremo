package uam.extremo.ui.wizards.newproject;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.eclipse.jface.dialogs.MessageDialog;

import uam.extremo.ui.nature.ExtremoProjectNature;
 
public class ExtremoProjectSupport {
    public static IJavaProject createProject(String projectName, java.net.URI location) { 
    	IJavaProject project = createBaseProject(projectName, location);
        try {
            addNature(project.getProject());
            
            String[] pathsDataset = {"model"};
            addToProjectStructure(project.getProject(), pathsDataset);
            
            IFolder binFolder = project.getProject().getFolder("bin");
            binFolder.create(false, true, null);
            project.setOutputLocation(binFolder.getFullPath(), null);
            
            List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
            IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
            LibraryLocation[] locations = JavaRuntime.getLibraryLocations(vmInstall);
            for (LibraryLocation element : locations) {
            	entries.add(JavaCore.newLibraryEntry(element.getSystemLibraryPath(), null, null));
            }
            project.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
            
            IFolder sourceFolder = project.getProject().getFolder("src");
            sourceFolder.create(false, true, null);
            
            IPackageFragmentRoot root = project.getPackageFragmentRoot(sourceFolder);
            IClasspathEntry[] oldEntries = project.getRawClasspath();
            IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
            System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
            newEntries[oldEntries.length] = JavaCore.newSourceEntry(root.getPath());
            project.setRawClasspath(newEntries, null);
            
            project.getPackageFragmentRoot(sourceFolder).createPackageFragment(projectName, false, null);
        }
        catch (CoreException e) {
            project = null;
            MessageDialog.openError(null, "Project creation", e.getMessage());
        }
 
        return project;
    }
 
    /**
     * Just do the basics: create a basic project.
     *
     * @param location
     * @param projectName
     */
    private static IJavaProject createBaseProject(String projectName, java.net.URI location) {
    	IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
    	IJavaProject javaProject = JavaCore.create(newProject); 
    	
    	if (!javaProject.exists()) {
            java.net.URI projectLocation = location;
            IProjectDescription desc = newProject.getWorkspace().newProjectDescription(newProject.getName());
            if (location != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
                projectLocation = null;
            }
 
            desc.setLocationURI(projectLocation);
            try {
                newProject.create(desc, null);
                if (!newProject.isOpen()) {
                    newProject.open(null);
                }
            }
            catch (CoreException e) {
            	MessageDialog.openError(null, "Project creation", e.getMessage());
            }
        }
 
        return javaProject;
    }
 
    private static void createFolder(IFolder folder) throws CoreException {
        IContainer parent = folder.getParent();
        if (parent instanceof IFolder) {
            createFolder((IFolder) parent);
        }
        if (!folder.exists()) {
            folder.create(true, true, null);
        }
    }
    
    private static void addToProjectStructure(IProject newProject, String[] paths) throws CoreException {
        for (String path : paths) {
            IFolder etcFolders = newProject.getFolder(path);
            createFolder(etcFolders);
        }
    }
    
    /**
     * Create a folder structure with a parent root, overlay, and a few child
     * folders.
     *
     * @param newProject
     * @param paths
     * @throws CoreException
     */
    private static void addNature(IProject project) throws CoreException {
        if (!project.hasNature(ExtremoProjectNature.NATURE_ID)) {
            IProjectDescription description = project.getDescription();
            
            String[] prevNatures = description.getNatureIds();
            String[] newNatures = new String[prevNatures.length + 2];
            System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
            
            newNatures[prevNatures.length] = ExtremoProjectNature.NATURE_ID;
            newNatures[prevNatures.length + 1] = JavaCore.NATURE_ID;
            description.setNatureIds(newNatures);
 
            IProgressMonitor monitor = null;
            project.setDescription(description, monitor);
        }
    }
}
