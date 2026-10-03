/**
 * @param {number[]} nums
 * @return {number[][]}
 */

var threeSum = function(nums) {
    const result = [];

    // Step 1: Sort the array
    nums.sort((a, b) => a - b);

    // Step 2: Fix the first element
    for (let i = 0; i < nums.length - 2; i++) {

        // Skip duplicate first elements
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }

        let left = i + 1;
        let right = nums.length - 1;

        // Step 3: Two pointer approach
        while (left < right) {

            const sum = nums[i] + nums[left] + nums[right];

            if (sum === 0) {
                result.push([nums[i], nums[left], nums[right]]);

                left++;
                right--;

                // Skip duplicate left values
                while (left < right && nums[left] === nums[left - 1]) {
                    left++;
                }

                // Skip duplicate right values
                while (left < right && nums[right] === nums[right + 1]) {
                    right--;
                }
            }

            else if (sum < 0) {
                left++;
            }

            else {
                right--;
            }
        }
    }

    return result;
};