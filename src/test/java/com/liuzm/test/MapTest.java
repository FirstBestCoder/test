package com.liuzm.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapTest {
    public static void main(String[] args) {


        ArrayList<JSONObject> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("hotelId", "1001");
            jsonObject.put("spId", "spId" + i);

            list.add(jsonObject);

            System.out.println();
        }
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("key", list);
        System.out.println(jsonObject1);
        JSONArray key = jsonObject1.getJSONArray("key");
        for (int i = 0; i < key.size(); i++) {
            JSONObject jsonObject = key.getJSONObject(i);
            String spId = (String) jsonObject.get("spId");
            String hotelId = (String) jsonObject.get("hotelId");
            System.out.println(spId + "=====" + hotelId);

        }
        System.out.println(key);

    }

    private static void CollectMap(JSONObject json) {
        ArrayList<Object> list = new ArrayList<>();
        System.out.println(json);

        list.add(json.get("hotelId"));
        if (list.size() % 10 == 0) {
            System.out.println(list);
            list.clear();
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    @Test
    public void test() {
       String path = "D://picture//10000001//1007701//00//18364132.jpg";
        File file = new File(path);
        boolean flag = file.exists();
        if(!flag){
            System.out.println("文件不存在");
        }
        System.out.println(flag);
    }



}
