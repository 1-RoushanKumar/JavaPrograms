package com.roushan._12_StacksAndQueues;

//the situation is when an array is full, we cannot insert any value now because the size of the array is fix.
//for taking care of array getting full, we are making dynamic stack.
//its taking O(n) complexity.
public class _05_a_DynamicStack extends _04_a_CustomStack {
    public _05_a_DynamicStack() {
        super(); //it will call CustomStack();
    }

    public _05_a_DynamicStack(int size) {
        super(size); //it will call CustomStack(int size);
    }

    //in dynamic stack, all things will remain the same except push
    //because we need to add an element dynamically.

    @Override
    public boolean push(int item) {
        //this takes care of it being full.
        if (this.isFull()){
            //double the array size.
            int[] temp = new int[data.length * 2];

            //copy all previous items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        //at this point, we know that array size is increased
        //insert the item normally
        return super.push(item);
    }
}
