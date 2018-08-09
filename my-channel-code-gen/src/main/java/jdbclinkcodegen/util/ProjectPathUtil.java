package jdbclinkcodegen.util;

import java.io.File;

import jdbclinkcodegen.ZjwlCodeGenApp;

public class ProjectPathUtil {
	/**
	 * 获取目标项目以及目标包绝对路径
	 * @param rootProjectDirName
	 * @param targetProjectDirName
	 * @param sourceCodePart
	 * @param packages
	 * @return
	 * 
	 * @author zai
	 * 2018-04-18
	 */
	public static String getTargetProjectPackagePath(
			String rootProjectDirName, 
			String targetProjectDirName,
			String sourceCodePart,
			String packages
			) {
		String packagesPart = packages.replaceAll("\\.", "/");
		
		String packagesPath = getTargetProjectSourceCodePath(rootProjectDirName, targetProjectDirName, sourceCodePart) + "/" + packagesPart;
		
		return packagesPath;
	}
	
	/**
	 * 获取目标项目源码资源根路径
	 * @param rootProjectDirName
	 * @param targetProjectDirName
	 * @param sourceCodePart
	 * @return
	 * 
	 * @author zai
	 * 2018-04-18
	 */
	public static String getTargetProjectSourceCodePath(
			String rootProjectDirName, 
			String targetProjectDirName,
			String sourceCodePart
			) {
		String sourceCodePath = getTargetProjectDir(rootProjectDirName, targetProjectDirName) + "/" + sourceCodePart;
		
		if (!new File(sourceCodePath).exists()) {
			throw new RuntimeException("No such dir:  "+ sourceCodePath);
		}
		
		return sourceCodePath;
	}
	
	
	/**
	 * 获取目标项目路径
	 * @param rootProjectDirName
	 * @param targetProjectDirName
	 * @return
	 * 
	 * @author zai
	 * 2018-04-18
	 */
	public static String getTargetProjectDir(
			String rootProjectDirName, 
			String targetProjectDirName
			) {
		String rootProjectPath = getRootProjectPath(rootProjectDirName);
		String path = rootProjectPath + "/" + targetProjectDirName;
		
		if (!new File(path).exists()) {
			throw new RuntimeException("No such project:  "+ path);
		}
		return path;
		
	}
	
	/**
	 * 向上查找根项目路径
	 * @param rootProjectDirName
	 * @return
	 * 
	 * @author zai
	 * 2018-04-18
	 */
	public static String getRootProjectPath(String rootProjectDirName) {
		File file = new File(ZjwlCodeGenApp.class.getResource("./").getFile());
		if (file.exists() && file.isDirectory()) {
			String path = "";
			while ((file = file.getParentFile()) != null) {
				if ((path = file.getAbsolutePath()).endsWith(rootProjectDirName)) {
					return path;
				}
			}
		}
		
		throw new RuntimeException("No such root project:  "+ rootProjectDirName);
	}
}
