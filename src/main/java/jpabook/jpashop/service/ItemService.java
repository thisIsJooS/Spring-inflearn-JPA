package jpabook.jpashop.service;

import jpabook.jpashop.Repository.ItemRepository;
import jpabook.jpashop.domain.Item.Book;
import jpabook.jpashop.domain.Item.Item;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

//    @Transactional
//    public void updateItem(Long itemId, Book param){
//        Item findItem = itemRepository.findOne(itemId);
//        findItem.setPrice(param.getPrice());
//        findItem.setName(param.getName());
//        findItem.setStockQuantity(param.getStockQuantity());
//    }

    /**
     * 상품수정 권장코드
     */
    @Transactional
    public void updateItem(Long id, String name, int price){
        Item item = itemRepository.findOne(id);
        item.setName(name);
        item.setPrice(price);
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }
}
