package cn.joongky.society.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import cn.joongky.exception.SysException;

public class BasicSysUtil {

	public static List<Integer> braceStr2List(String str) {
		Pattern pattern = Pattern.compile("(\\d+)");
		Matcher m = pattern.matcher(str);
		List<Integer> list = new ArrayList<Integer>();
		while (m.find()) {
			list.add(Integer.parseInt(m.group()));
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		if (obj instanceof String) {
			if ("".equals(obj))
				return true;
		}
		if (obj instanceof Collection<?>) {
			if (((Collection) obj).size() > 0)
				return true;
		}
		return false;
	}

	public static <N extends Object> void mergeList(List<N> baseList, List<N> mergeList) {
		for (N o : mergeList) {
			if (!baseList.contains(o)) {
				baseList.add(o);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public static List<Class> listClassesByPackage(String p) throws SysException {
		try {
			List<Class> clzs = new ArrayList<Class>();
			String packagePath = p.replace(".", "/");
			URL url = Thread.currentThread().getContextClassLoader().getResource(packagePath);
			File file = new File(url.getPath());
			if (!file.exists())
				throw new SysException("初始化的包名路径不正确");
			File[] files = file.listFiles(new FileFilter() {

				@Override
				public boolean accept(File pathname) {
					if (pathname.getName().endsWith(".class"))
						return true;
					return false;
				}
			});
			for (File f : files) {
				String cname = p + "." + FilenameUtils.getBaseName(f.getName());
				Class<?> clz = Class.forName(cname);
				clzs.add(clz);
			}
			return clzs;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Class> listClassesByAnnotation(String p, Class annotation) throws SysException {
		try {
			List<Class> clzs = new ArrayList<Class>();
			String packagePath = p.replace(".", "/");
			URL url = Thread.currentThread().getContextClassLoader().getResource(packagePath);
			File file = new File(url.getPath());
			if (!file.exists())
				throw new SysException("初始化的包名路径不正确");
			File[] files = file.listFiles(new FileFilter() {

				@Override
				public boolean accept(File pathname) {
					if (pathname.getName().endsWith(".class"))
						return true;
					return false;
				}
			});
			for (File f : files) {
				String cname = p + "." + FilenameUtils.getBaseName(f.getName());
				Class<?> clz = Class.forName(cname);
				if (clz.isAnnotationPresent(annotation))
					clzs.add(clz);
			}
			return clzs;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveFileToServer(MultipartFile multipartFile, String path) throws IOException {
		InputStream inputStream = multipartFile.getInputStream();
		OutputStream outputStream = new FileOutputStream(path);
		byte[] buffer = multipartFile.getBytes();
		int byteread = 0;
		while ((byteread = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, byteread);
			outputStream.flush();
		}
		outputStream.close();
		inputStream.close();
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static void download(String srcUrl, String localPath) {
		// 构造URL
		URL url;
		try {
			url = new URL(srcUrl);
			// 打开连接
			URLConnection con = url.openConnection();
			// 设置请求超时为5s
			con.setConnectTimeout(5 * 1000);
			// 输入流
			InputStream is = con.getInputStream();

			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			// File sf=new File(savePath);
			// if(!sf.exists()){
			// sf.mkdirs();
			// }
			OutputStream os = new FileOutputStream(localPath);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static <T> List<String> listField(List<T> objs, String field) {

		List<String> list = new ArrayList<String>();
		for (Object obj : objs) {
			list.add(getField(obj, field));
		}
		return list;
	}

	private static String getField(Object obj, String field) {
		String str = null;
		try {
			Method getMethod = obj.getClass().getMethod("get" + capName(field));
			str = (String) getMethod.invoke(obj);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return str;
	}

	private static String capName(String name) {
		char[] cs = name.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);
	}
}
