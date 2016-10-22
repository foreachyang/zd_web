package com.cn.service.Impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

	@Service
	@Configuration
	public class FileSize{

		private final static ForkJoinPool forkJoinPool=  new  ForkJoinPool();
		
		private static class FileSizeFinder extends RecursiveTask<Long>{

			 File file;
			 
			 public FileSizeFinder(File file) {this.file=file;}
			 
			@Override protected Long compute() {
				long  size=0;
				if(file.isFile()) {
					size=file.length();
				}else {
					File[] children = file.listFiles();
					if(children!=null) {
					List<ForkJoinTask<Long>> tasks= new ArrayList<ForkJoinTask<Long>>();
					
					for(File child:children) {
						 if(child.isFile()) {
							 size+=child.length();
						 }else {
							 tasks.add(new FileSizeFinder(child));
						 }
					}
					
					for(ForkJoinTask<Long> task : invokeAll(tasks)) {
						size+=task.join();
					}
					
					}
				}
				
				return size;
			}
			
		}
		
		public long getfilesize() {
     		
     				long total =forkJoinPool.invoke(new FileSizeFinder(new File("E:\\521\\zd_web_")));
     				return total;
		}
		
}
