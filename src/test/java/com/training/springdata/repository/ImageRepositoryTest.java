package com.training.springdata.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.springdata.entities.Image;

@SpringBootTest
public class ImageRepositoryTest {

	@Autowired
	private ImageRepository imageRepository;

	@Test
	public void testImageSave() throws IOException {
		Image image = new Image();
		

		File imageFile = new File("image file path");
		byte[] imageContent = new byte[(int) imageFile.length()];
		FileInputStream fileInputStream = new FileInputStream(imageFile);
		fileInputStream.read(imageContent);
		image.setName(imageFile.getName());
		image.setData(imageContent);
		imageRepository.save(image);
		fileInputStream.close();
	}

	@Test
	public void testReadImaget() throws IOException {
		Image image = imageRepository.findById(1).orElse(null);
		File imageFile = new File("folder path"+image.getName());
		FileOutputStream fileOutputStream=new FileOutputStream(imageFile);
		fileOutputStream.write(image.getData());
		fileOutputStream.close();
	}
}
