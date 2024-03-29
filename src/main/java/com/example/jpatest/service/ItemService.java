package com.example.jpatest.service;

import com.example.jpatest.dto.ItemDto;
import com.example.jpatest.entity.Item;
import com.example.jpatest.entity.ItemImg;
import com.example.jpatest.repository.ItemImgRepo;
import com.example.jpatest.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.time.LocalDateTime;

@Transactional
@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemImgRepo itemImgRepo;
    private Pageable pageable;

    // 상품 삭제
    public void deleteItem(Long id){
        // 연관관계 엔티티 삭제 - 주 와 종 관계에서 종 먼저 삭제하고 주 삭제
        itemImgRepo.deleteByItemId(id);
        itemRepo.deleteById(id);
    }

    // 상품 수정 적용 - entity객체 수정
    public void updateItem(ItemDto itemDto){
        Item item = itemRepo.findById(itemDto.getId()).get();
        item.updateItem(itemDto);
    }

    //수정 페이지
    public ItemDto getItemDtl(Long id){
        Item item = itemRepo.findById(id).get();
        ItemDto itemDto = ItemDto.of(item);
        return itemDto;
    }

    // 상세페이지
    public Item detail(Long id){
        return itemRepo.findById(id).get();
    }


    // 전체글 불러오기
    public Page<Item> allList(Pageable pageable){
        return itemRepo.findAllByOrderByIdDesc(pageable);
    }


    public void imgUpload(MultipartFile image, ItemDto itemDto){
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int min = now.getMinute();
        int sec = now.getSecond();

        //파일 업로드 절대경로
        String absPath = new File("/Users/dw-027/Desktop").getAbsolutePath()+"/";
        //파일의 새이름
        String newName =  "img"+hour+min+sec;
        //확장자 추출
        String ext = "."+image.getOriginalFilename().replaceAll("^.*\\.(.*)$","$1");
        //저장될 폴더 경로
        String path = "img/"+year+"/"+month+"/"+day;
        try{
            File file = new File(absPath+path);
            if(!file.exists()){
                file.mkdirs();
            }
            file = new File(absPath+path+"/"+newName+ext);
            image.transferTo(file); //파일 복사 -업로드
            
            //데이터베이스 저장
            Item item = Item.of(itemDto);
            itemRepo.save(item);

            ItemImg itemImg = new ItemImg();
            itemImg.setImgPath(path);
            itemImg.setImgName(newName+ext);
            itemImg.setOriginalName(image.getOriginalFilename());
            itemImg.setItem(item);

            itemImgRepo.save(itemImg);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
