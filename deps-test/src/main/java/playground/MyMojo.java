package playground;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Goal which touches a timestamp file.
 *
 * @goal touch
 * 
 * @phase compile
 */
public class MyMojo
    extends AbstractMojo
{

    /**
     * The Maven Project.
     *
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project = null;

    /**
     * Execute Mojo.
     *
     * @throws MojoExecutionException If an error occurs.
     * @throws MojoFailureException If an error occurs.
     */
    public void execute() throws MojoExecutionException,
            MojoFailureException {


       Set<Artifact> dependencies =  project.getArtifacts();
        List<String> compileClasspathEl = null;
        try {
            compileClasspathEl = project.getCompileClasspathElements();
            List<String> modules = project.getModules();
            List<MavenProject> collectedprojects = project.getCollectedProjects();
            getLog().info("++++++++ deps: " +dependencies.toString());
            getLog().info("++++++++ comple El: " +compileClasspathEl.toString());
            getLog().info("++++++++ modules: " + modules);
            getLog().info("++++++++ coll projects: " +collectedprojects.toString());
        } catch (DependencyResolutionRequiredException e) {
            e.printStackTrace();
        }



    }
}
