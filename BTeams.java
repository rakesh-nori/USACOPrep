import java.util.Arrays;
import java.util.Scanner;

public class BTeams
{
	private int [] sz;
	private int [][] teams;
	private int [] skillz;
	private int minDiff;
	public void process()
	{
		int teamSkillz[] = new int[4];
		teamSkillz[0] = getTeamSkill(0);
		teamSkillz[1] = getTeamSkill(1);
		teamSkillz[2] = getTeamSkill(2);
		teamSkillz[3] = getTeamSkill(3);
		Arrays.sort(teamSkillz);
		int val = teamSkillz[3] - teamSkillz[0];
		if (val < minDiff)
			minDiff = val;
	}
	public int getTeamSkill(int team)
	{
		int skill = 0;
		for (int i = 0; i < teams[team].length; i++)
		{
			
			skill += skillz[teams[team][i]];
		}
		return skill;
	}
	public void findBalanced(int [] skill)
	{
		sz = new int[4];
		teams = new int[4][3];
		skillz = skill;
		minDiff = Integer.MAX_VALUE;
		makeTeams(0);
		System.out.println(minDiff);
	}
	public void makeTeams(int cow)
	{
		if (cow == 12)
			process();
		for (int i = 0; i < 4; i++)
		{
			if (sz[i] < 3)
			{
				teams[i][sz[i]] = cow;
				sz[i]++;
				makeTeams(cow+1);
				sz[i]--;
				teams[i][sz[i]] -= cow;
			}
		}
	}
	public static void main(String []args)
	{
		int [] skill = new int[12];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 12; i++)
			skill[i] = sc.nextInt();
		sc.close();
		BTeams bbb = new BTeams();
		bbb.findBalanced(skill);
	}
}
